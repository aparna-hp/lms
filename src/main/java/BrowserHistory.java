class BrowserHistory {

    private String[] history;
    int current;
    int size;

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.forward(1));
        browserHistory.visit("linkedIn.com");
        System.out.println(browserHistory.forward(2));
        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));
    }

    public BrowserHistory(String homepage) {
        history = new String[5000];
        history[0]= homepage;
        current =0;
        size = 1;
    }

    public void visit(String url) {
        int temp = current+1;
        while (temp < size) {
            history[temp] = null;
            temp++;
        }
        current++;
        size = current+1;
        history[current]= url;
    }

    public String back(int steps) {
        if(size ==0) {
            return null;
        }

        if(steps > current) {
            current =0;
        }
        else {
            current = current - steps;
        }

        return history[current];
    }

    public String forward(int steps) {
        if(size == 0) {
            return null;
        }
        int diff = size - current -1;
        if(steps > diff) {
            current = size-1;
        } else {
            current = current + steps;
        }
        return history[current];
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */