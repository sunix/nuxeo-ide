package org.nuxeo.ide.sdk.features.security.permissionvisibility;

public class PermissionVisibilityItem {

    private boolean show;

    private String order;

    private String permissionName;

    public PermissionVisibilityItem(String permissionName, String order,
            boolean show) {
        this.permissionName = permissionName;
        this.order = order;
        this.show = show;
    }

    public boolean getShow() {
        return show;
    }

    public void setShow(boolean show) {
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

    @Override
    public String toString() {
        return permissionName;
    }
}
