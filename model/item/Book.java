package model.item;

import java.util.Random;

/**
 * 
 * @author Corentin Hardy
 *
 */
public class Book extends Item{
    private Badge badge;
    
    public Book(String name, String description, Subject subject) {
        super(name, description);
        this.subject = subject;
    }
    public Book(Player player, Subject subject) {
        super(player, "", "");
        this.subject = subject;
        this.generateName();
        this.generateDescription();
    }
    
    private void generateName(){
        this.setName("Book of " + this.getSubject().getName() + " " 
                + this.getSubject().getPrecision()); 
    }
    private void generateDescription(){
        this.setDescription("This can give you some knowledge about this subject."); 
    }
    
    public Subject getSubject(){
        return subject;
    }

    @Override
    public void effect(Student student) {
        LabSession labS = new LabSession(this.getPlayer(), subject);
        LectureSession lectS = new LectureSession(this.getPlayer(), subject, labS);
        if (student.haveThisItem(labS)){
            if (student.haveThisItem(lectS)){
                System.out.println(Language.translate("You already have it."));
                return; 
            }else{
                this.addAndRm(lectS); 
                return ;
            }
        }
        if (student.haveThisItem(lectS)){
            this.addAndRm(labS); 
            return ;
        }
        this.addAndRm( ((new Random()).nextBoolean() ? labS : lectS) ); 
    }

    private void addAndRm(SessionSubject sessub){
        this.getPlayer().addItem( sessub ); 
        sessub.forget();
    }
}

