package domain;

public interface Callable <V>{
    V call() throws Exception;
}
