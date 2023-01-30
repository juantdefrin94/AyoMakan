package state;

public class State {

	private IState state;
	
	public State() {
		state = new OrderState();
	}
	
	public void setState(IState state) {
		this.state = state;
	}
	
	public IState getState() {
		return state;
	}

}
