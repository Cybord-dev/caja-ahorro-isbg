package com.business.cybord.states.solicitudes;


import org.jeasy.states.api.AbstractEvent;
import org.jeasy.states.api.Event;
import org.jeasy.states.api.FiniteStateMachineException;
import org.jeasy.states.api.State;

import com.business.cybord.models.error.IsbgServiceException;

public interface ISolicitud {
	void define(String initialState);
	State fire(AbstractEvent event) throws FiniteStateMachineException;
	State nextState() throws IsbgServiceException;
	boolean compare(State future);
	Event getLastEvent() throws FiniteStateMachineException;
}