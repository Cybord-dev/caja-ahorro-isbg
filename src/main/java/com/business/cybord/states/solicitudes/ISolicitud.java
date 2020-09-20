package com.business.cybord.states.solicitudes;

import org.jeasy.states.api.Event;
import org.jeasy.states.api.FiniteStateMachineException;
import org.jeasy.states.api.State;

public interface ISolicitud {

	void define(String initialState);
	State fire(Event event) throws FiniteStateMachineException;
	Event getLastEvent() throws FiniteStateMachineException;
}
