package SeleniumSessions.HomeAssignment1.ClassroomActivities;

public class Edge extends Browser{

    public void takeSnap() {

    }

    public void clearCookies() {
        driver.manage().deleteAllCookies();
    }

    public static void main(String[] args) {

        Edge mthd1 = new Edge();
        mthd1.openURL();
        mthd1.takeSnap();
        mthd1.navigateBack();
        mthd1.closeBrowser();
        mthd1.clearCookies();
        System.out.println(mthd1.browserName+" " + mthd1.browserVersion);
    }
}
