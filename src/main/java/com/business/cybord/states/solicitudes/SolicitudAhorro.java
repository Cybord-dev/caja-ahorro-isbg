package com.business.cybord.states.solicitudes;

import java.util.HashSet;
import java.util.Set;

import org.jeasy.states.api.Event;
import org.jeasy.states.api.FiniteStateMachine;
import org.jeasy.states.api.FiniteStateMachineException;
import org.jeasy.states.api.State;
import org.jeasy.states.api.Transition;
import org.jeasy.states.core.FiniteStateMachineBuilder;
import org.jeasy.states.core.TransitionBuilder;

import com.business.cybord.states.ValidacionConta;
import com.business.cybord.states.ValidacionRh;
import com.business.cybord.states.events.ValidaContaEvent;
import com.business.cybord.states.events.ValidaRhEvent;

public class SolicitudAhorro implements ISolicitud{

	private FiniteStateMachine turnstileStateMachine;
	private Set<State> states ;
	private Set<Transition> transitions ;

	public SolicitudAhorro() {
		State creada = new State("SolicitudCreadaEvent");
		State validaRh = new State("ValidaRhEvent");
		State validaConta = new State("ValidaContaEvent");
		states= new HashSet<>();
		transitions= new HashSet<>();
		states.add(creada);
		states.add(validaRh);
		states.add(validaConta);

		Transition validacionRh = new TransitionBuilder()
				.name("validacionRh")
				.sourceState(creada)
				.eventType(ValidaRhEvent.class)
				.eventHandler(new ValidacionRh())
				.targetState(validaRh)
				.build();

		Transition validacionConta = new TransitionBuilder()
				.name("validacionConta")
				.sourceState(validaRh)
				.eventType(ValidaContaEvent.class)
				.eventHandler(new ValidacionConta())
				.targetState(validaConta)
				.build();
		transitions.add(validacionRh);
		transitions.add(validacionConta);
	}

	@Override
	public void define(String initialState) {
		State state = new State(initialState);
		turnstileStateMachine = new FiniteStateMachineBuilder(states, state).registerTransitions(transitions).build();
		
	}

	@Override
	public State fire(Event event) throws FiniteStateMachineException {
		return turnstileStateMachine.fire(event);
	}

	@Override
	public Event getLastEvent() throws FiniteStateMachineException {
		return turnstileStateMachine.getLastEvent();
	}

}
