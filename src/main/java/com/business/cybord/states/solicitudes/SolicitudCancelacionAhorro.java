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
import com.business.cybord.states.ValidacionAdmin;
import com.business.cybord.states.ValidacionConta;
import com.business.cybord.states.ValidacionFinalizada;
import com.business.cybord.states.ValidacionGerencia;
import com.business.cybord.states.ValidacionRh;
import com.business.cybord.states.events.SolicitudFinalizadaEvent;
import com.business.cybord.states.events.ValidaAdminEvent;
import com.business.cybord.states.events.ValidaContaEvent;
import com.business.cybord.states.events.ValidaGerenciaEvent;
import com.business.cybord.states.events.ValidaRhEvent;

public class SolicitudCancelacionAhorro implements ISolicitud {

	private FiniteStateMachine turnstileStateMachine;
	private Set<State> states;
	private Set<Transition> transitions;

	public SolicitudCancelacionAhorro() {
		State creada = new State(EventFactoryTypeEnum.SOLICITUD_CREADA.getState());
		State validaRh = new State(EventFactoryTypeEnum.VALIDA_RH.getState());
		State validaConta = new State(EventFactoryTypeEnum.VALIDA_CONTA_EVENT.getState());
		State validaGerencia = new State(EventFactoryTypeEnum.VALIDA_GERENCIA.getState());
		State validaTso = new State(EventFactoryTypeEnum.VALIDA_TESO.getState());
		State finalizada = new State(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState());
		states = new HashSet<>();
		transitions = new HashSet<>();
		states.add(creada);
		states.add(validaRh);
		states.add(validaConta);

		Transition validacionRh = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_RH.getState())
				.sourceState(creada).eventType(ValidaRhEvent.class).eventHandler(new ValidacionRh())
				.targetState(validaRh).build();

		Transition validacionConta = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_CONTA_EVENT.getState())
				.sourceState(validaRh).eventType(ValidaContaEvent.class).eventHandler(new ValidacionConta())
				.targetState(validaConta).build();

		Transition validacionGerncia = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_GERENCIA.getState())
				.sourceState(validaConta).eventType(ValidaGerenciaEvent.class).eventHandler(new ValidacionGerencia())
				.targetState(validaGerencia).build();

		Transition validacionAdmin = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_TESO.getState())
				.sourceState(validaGerencia).eventType(ValidaAdminEvent.class).eventHandler(new ValidacionAdmin())
				.targetState(validaTso).build();

		Transition validacionGernci2 = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_GERENCIA.getState())
				.sourceState(validaTso).eventType(ValidaAdminEvent.class).eventHandler(new ValidacionGerencia())
				.targetState(validaGerencia).build();

		Transition solicitudFinalizada = new TransitionBuilder()
				.name(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState()).sourceState(validaGerencia)
				.eventType(SolicitudFinalizadaEvent.class).eventHandler(new ValidacionFinalizada())
				.targetState(finalizada).build();

		transitions.add(validacionRh);
		transitions.add(validacionConta);
		transitions.add(validacionGerncia);
		transitions.add(validacionAdmin);
		transitions.add(validacionGernci2);
		transitions.add(solicitudFinalizada);

		State state = new State(EventFactoryTypeEnum.SOLICITUD_CREADA.getState());
		turnstileStateMachine = new FiniteStateMachineBuilder(states, state).registerTransitions(transitions)
				.registerFinalState(finalizada).build();
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