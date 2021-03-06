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
import com.business.cybord.states.events.ValidaAvalesEvent;
import com.business.cybord.states.events.ValidaDireccionEvent;
import com.business.cybord.states.events.ValidaGerenciaInternaEvent;
import com.business.cybord.states.events.ValidaRhEvent;
import com.business.cybord.states.events.ValidaTesoEvent;
import com.business.cybord.states.handlers.ValidaDireccion;
import com.business.cybord.states.handlers.ValidacionAval;
import com.business.cybord.states.handlers.ValidacionFinalizada;
import com.business.cybord.states.handlers.ValidacionGerenciaInterna;
import com.business.cybord.states.handlers.ValidacionRh;
import com.business.cybord.states.handlers.ValidacionTesoreria;

public class SolicitudPrestamoInterno implements ISolicitud {

	private FiniteStateMachine turnstileStateMachine;
	private Set<State> states;
	private Set<Transition> transitions;

	public SolicitudPrestamoInterno() {
		State creada = new State(EventFactoryTypeEnum.SOLICITUD_CREADA.getState());
		State validacionAval = new State(EventFactoryTypeEnum.VALIDA_AVALES.getState());
		State validaRh = new State(EventFactoryTypeEnum.VALIDA_RH.getState());
		State validaGerencia = new State(EventFactoryTypeEnum.VALIDA_GERENCIA_INTERNA.getState());
		State validaTso = new State(EventFactoryTypeEnum.VALIDA_TESO.getState());
		State validaDireccion = new State(EventFactoryTypeEnum.VALIDA_DIRECCION.getState());
		State finalizada = new State(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState());
		states = new HashSet<>();
		transitions = new HashSet<>();
		states.add(creada);
		states.add(validacionAval);
		states.add(validaRh);
		states.add(validaDireccion);
		states.add(validaGerencia);
		states.add(validaTso);
		states.add(finalizada);

		Transition validacionAvales = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_AVALES.getState())
				.sourceState(creada).eventType(ValidaAvalesEvent.class).eventHandler(new ValidacionAval())
				.targetState(validacionAval).build();
		
		Transition validacionRh = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_RH.getState())
				.sourceState(validacionAval).eventType(ValidaRhEvent.class).eventHandler(new ValidacionRh())
				.targetState(validaRh).build();
		
		Transition validacionDireccion = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_DIRECCION.getState())
				.sourceState(creada).eventType(ValidaDireccionEvent.class).eventHandler(new ValidaDireccion())
				.targetState(validaDireccion).build();
		
		Transition validacionDireccionRh = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_DIRECCION.getState())
				.sourceState(validaRh).eventType(ValidaDireccionEvent.class).eventHandler(new ValidaDireccion())
				.targetState(validaDireccion).build();

		Transition validacionGerncia = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_GERENCIA_INTERNA.getState())
				.sourceState(validaRh).eventType(ValidaGerenciaInternaEvent.class).eventHandler(new ValidacionGerenciaInterna())
				.targetState(validaGerencia).build();
		
		Transition validacionDireccionGerencia = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_DIRECCION.getState())
				.sourceState(validaGerencia).eventType(ValidaDireccionEvent.class).eventHandler(new ValidaDireccion())
				.targetState(validaDireccion).build();

		Transition validacionAdmin = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_TESO.getState())
				.sourceState(validaGerencia).eventType(ValidaTesoEvent.class).eventHandler(new ValidacionTesoreria())
				.targetState(validaTso).build();

		Transition validacioDireccionTeso = new TransitionBuilder().name(EventFactoryTypeEnum.VALIDA_TESO.getState())
				.sourceState(validaDireccion).eventType(ValidaTesoEvent.class).eventHandler(new ValidacionTesoreria())
				.targetState(validaTso).build();

		Transition solicitudFinalizada = new TransitionBuilder()
				.name(EventFactoryTypeEnum.SOLICITUD_TERMINADA.getState()).sourceState(validaTso)
				.eventType(SolicitudFinalizadaEvent.class).eventHandler(new ValidacionFinalizada())
				.targetState(finalizada).build();

		transitions.add(validacionAvales);
		transitions.add(validacionRh);
		transitions.add(validacionGerncia);
		transitions.add(validacionAdmin);
		transitions.add(solicitudFinalizada);
		
		
		//Condiciones especiales
		transitions.add(validacionDireccion);
		transitions.add(validacioDireccionTeso);
		transitions.add(validacionDireccionRh);
		transitions.add(validacionDireccionGerencia);

		State state = new State(EventFactoryTypeEnum.SOLICITUD_CREADA.getState());
		turnstileStateMachine = new FiniteStateMachineBuilder(states, state).registerTransitions(transitions).build();
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