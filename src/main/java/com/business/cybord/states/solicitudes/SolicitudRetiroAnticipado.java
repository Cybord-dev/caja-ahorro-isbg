package com.business.cybord.states.solicitudes;

import org.jeasy.states.api.AbstractEvent;
import org.jeasy.states.api.Event;
import org.jeasy.states.api.FiniteStateMachineException;
import org.jeasy.states.api.State;

import com.business.cybord.models.error.IsbgServiceException;

public class SolicitudRetiroAnticipado implements ISolicitud {

	@Override
	public void define(String initialState) {
		// TODO Auto-generated method stub

	}

	@Override
	public State fire(AbstractEvent event) throws FiniteStateMachineException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event getLastEvent() throws FiniteStateMachineException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean compare(State future) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public State nextState() throws IsbgServiceException {
		// TODO Auto-generated method stub
		return null;
	}

}
