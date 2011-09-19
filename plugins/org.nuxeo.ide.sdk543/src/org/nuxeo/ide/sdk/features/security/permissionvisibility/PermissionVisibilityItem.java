package org.nuxeo.ide.sdk.features.security.permissionvisibility;


public class PermissionVisibilityItem {

    private Boolean show;

    private String order;

    private String permissionName;

    public PermissionVisibilityItem(String permissionName, String order, Boolean show) {
        this.permissionName= permissionName;
        this.order= order;
        this.show = show;
    }

    public Boolean getShow() {
        return show;
    }

    public void setShow(Boolean show) {
        this.show = show;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

}
