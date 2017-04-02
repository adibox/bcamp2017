package curs.events;

import javax.enterprise.event.Observes;

public class EventReceiver {
	void recvAdd(@Observes BookAddedEvent pEvent) {
		System.out.println("+++" + pEvent);
	}
	
	void recvDel(@Observes BookRemovedEvent pEVent) {
		System.out.println("---" + pEVent);
	
	}
}
