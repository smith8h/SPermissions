package smith.lib.tools.perms;

public interface SPermissionsCallback {

    /**
     * Called when the permissions are changed for the application.
     *
     * @param isGranted   true if the permissions are granted.
     * @param requestCode the request code that has been sent with the ask method to distinguish
     *                    between permissions requests.
     */
    void onAskPermissionResult(boolean isGranted, int requestCode);
}
