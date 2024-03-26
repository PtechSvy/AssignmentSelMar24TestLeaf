package SeleniumSessions.HomeAssignment1.ClassroomActivities;

public class Safari extends Browser{

    public void readerMode() {}

    public void fullScreenMode() {}

    public static void main(String[] args) {

        Safari mthd = new Safari();
        mthd.openURL();
        mthd.fullScreenMode();
        mthd.navigateBack();
        mthd.closeBrowser();

    }
}
