package ds.misc;

public class BrowserHistory {
    private String[] history = new String[5000];
    private int _currentStep;
    private int _top;
    
    public BrowserHistory(String homepage) {
        _currentStep = 0;
        _top = 0;
        history[_top] = homepage;
    }
    
    public void visit(String url) {
    	++_currentStep;
        _top = _currentStep;
        history[_top] = url;
    }
    
    public String back(int steps) {
        _currentStep -= steps;
        
        if (_currentStep < 0) {
            _currentStep = 0;
        }

        return history[_currentStep];
    }
    
    public String forward(int steps) {
        _currentStep += steps;
        
        if (_currentStep > _top) {
            _currentStep = _top;
        }
        
        return history[_currentStep];
    }
    
    public static void main(String[] args) {
    	BrowserHistory bh = new BrowserHistory("jrbilt.com");
    	bh.visit("uiza.com");
    	bh.forward(3);
    	bh.forward(3);
    	bh.visit("fveyl.com");
    	bh.visit("hyhqfqf.com");
    	bh.back(3);
    	bh.visit("cccs.com");
    	bh.visit("bivz.com");   
    	bh.forward(6);
    	bh.back(1);
    	bh.visit("cmbw.com");
    	bh.visit("iywwwfn.com");   
    	bh.visit("sktbhdx.com"); 
    	bh.forward(8);
    	bh.forward(10);    	
    	bh.visit("bskj.com");
    	bh.visit("thw.com");  
    	bh.back(6);
    	bh.visit("hgesj.com");    	
    }
}
