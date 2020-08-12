package io.chengsean.designpatterndemo;

public class ChainOfResponsibility {

    static abstract class Handler {

        protected Handler successor;


        public Handler(Handler successor) {
            this.successor = successor;
        }


        protected abstract void handleRequest(Request request);
    }
    static class ConcreteHandler1 extends Handler {

        public ConcreteHandler1(Handler successor) {
            super(successor);
        }


        @Override
        protected void handleRequest(Request request) {
            if (request.getType() == RequestType.TYPE1) {
                System.out.println(request.getName() + " is handle by "+this.getClass().getSimpleName());
                return;
            }
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }
    static class ConcreteHandler2 extends Handler {

        public ConcreteHandler2(Handler successor) {
            super(successor);
        }


        @Override
        protected void handleRequest(Request request) {
            if (request.getType() == RequestType.TYPE2) {
                System.out.println(request.getName() + " is handle by "+this.getClass().getSimpleName());
                return;
            }
            if (successor != null) {
                successor.handleRequest(request);
            }
        }
    }
    static class Request {

        private RequestType type;
        private String name;


        public Request(RequestType type, String name) {
            this.type = type;
            this.name = name;
        }


        public RequestType getType() {
            return type;
        }


        public String getName() {
            return name;
        }
    }
    enum RequestType {
        TYPE1, TYPE2
    }
    public static void main(String[] args) {

        Handler handler1 = new ConcreteHandler1(null);
        Handler handler2 = new ConcreteHandler2(handler1);

        Request request1 = new Request(RequestType.TYPE1, "request1");
        handler2.handleRequest(request1);

        Request request2 = new Request(RequestType.TYPE2, "request2");
        handler2.handleRequest(request2);
    }
}
