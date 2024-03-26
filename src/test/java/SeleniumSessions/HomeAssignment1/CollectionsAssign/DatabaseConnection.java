package SeleniumSessions.HomeAssignment1.CollectionsAssign;

public interface DatabaseConnection {

    public abstract void connect() ;

    public abstract void disconnect() ;

    public abstract void executeUpdate() ;
}
