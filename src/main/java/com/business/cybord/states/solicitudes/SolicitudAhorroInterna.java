package com.business.cybord.states.solicitudes;

import java.util.HashSet;
import java.util.Set;

import org.jeasy.states.api.AbstractEvent;
import org.jeasy.states.api.Event;
import org.jeasy.states.api.FiniteStateMachine;
import org.jeasy.states.api.FiniteStateMachineException;
import org.jeasy.states.api.State;
import org.jeasy.states.api.Transition;
import org.jeasy.states.core.FiniteStateMachineBuilder;
import org.jeasy.states.core.TransitionBuilder;
import org.springframework.http.HttpStatus;

import com.business.cybord.models.dtos.SolicitudDto;
import com.business.cybord.models.enums.EventFactoryTypeEnum;
import com.business.cybord.models.error.IsbgServiceException;
import com.business.cybord.states.events.SolicitudFinalizadaEvent;
import com.business.cybord.states.events.ValidaRhEvent;
import com.business.cybord.states.handlers.ValidacionFinalizada;
import com.business.cybord.states.handlers.ValidacionRh;

public class SolicitudAhorroInterna implements ISolicitud {

	private FiniteStateMachine turnstileStateMachine;
	private Set<State> states;
	private Set<Transition> transitions;

	public SolicitudAhorroInterna() {
		State creada = new State(EventFactoryTypeEnum.SOLICITUD_CREADA.getState());
		State validaRh = new State(EventFactoryTypeEnum.VALIDA_RH.getState());
		State finalizada = new State(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState());
		states = new HashSet<>();
		transitions = new HashSet<>();
		states.add(creada);
		states.add(validaRh);
		states.add(finalizada);

		Transition validacionRh = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_RH.getState())
				.sourceState(creada).eventType(ValidaRhEvent.class).eventHandler(new ValidacionRh())
				.targetState(validaRh).build();

		Transition solicitudFinalizada = new TransitionBuilder()
				.name(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState()).sourceState(validaRh)
				.eventType(SolicitudFinalizadaEvent.class).eventHandler(new ValidacionFinalizada())
				.targetState(finalizada).build();

		transitions.add(validacionRh);
		transitions.add(solicitudFinalizada);

		turnstileStateMachine = new FiniteStateMachineBuilder(states, creada).registerTransitions(transitions)
				.build();
	}

	@Override
	public void define(String initialState) {
	}

	@Override
	public State fire(AbstractEvent event) throws FiniteStateMachineException {
		return turnstileStateMachine.fire(event);
	}

	@Override
	public Event getLastEvent() throws FiniteStateMachineException {
		return turnstileStateMachine.getLastEvent();
	}

	@Override
	public boolean compare(State future) {
		return turnstileStateMachine.getCurrentState().equals(future);
	}

	@Override
	public State nextState() throws IsbgServiceException {
		try {
			State currentState = turnstileStateMachine.getCurrentState();
			for (EventFactoryTypeEnum value : EventFactoryTypeEnum.values()) {
				State state = turnstileStateMachine.fire(value.getEnumValue().getInstance(new SolicitudDto()));
				if (!currentState.equals(state)) {
					return state;
				}
			}
			throw new IsbgServiceException("No hay un estado siguiente", "No hay un estado siguiente",
					HttpStatus.CONFLICT.value());
		} catch (FiniteStateMachineException e) {
			throw new IsbgServiceException(e.getMessage(), "No hay un estado siguiente", HttpStatus.CONFLICT.value());
		}
	}
}