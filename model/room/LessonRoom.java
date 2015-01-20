package model.room;

import model.Question;

public abstract class LessonRoom extends Room {
	
	private Question question ;

	public LessonRoom(String description) {
		super(description);
	}
	
	public void giveAnswer(){
		System.out.println("Q : "+this.question.question+"\nA : "+this.question.answer);
	}

}
