package clock;

public class Clock {
    
    public static void main(String[] args) throws QueueOverflowException {
        Model model = new Model();
        View view = new View(model);
        model.addObserver(view);
        Controller controller = new Controller(model, view);
        
        view.addtoList();
        
        
        
    }
}
