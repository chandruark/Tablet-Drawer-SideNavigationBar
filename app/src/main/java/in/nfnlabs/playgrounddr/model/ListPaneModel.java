package in.nfnlabs.playgrounddr.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Model Class for Main Listing Attributes
 */
public  class ListPaneModel {
    public final String id;

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getDetails() {
        return details;
    }

    public static List<ListPaneModel> getListitems() {
        return Listitems;
    }

    public static void setListitems(List<ListPaneModel> listitems) {
        Listitems = listitems;
    }

    public final String content;
    public final String details;
    public static List<ListPaneModel> Listitems = new ArrayList<>();

    public ListPaneModel(String id, String content, String details) {
        this.id = id;
        this.content = content;
        this.details = details;
    }

    @Override
    public String toString() {
        return content;
    }
}