package in.nfnlabs.playgrounddr.DragandDropconsole.model;

public interface MonthItem {

    enum MonthItemType {
        HEADER, MONTH
    }

    MonthItemType getType();

    String getName();
}
