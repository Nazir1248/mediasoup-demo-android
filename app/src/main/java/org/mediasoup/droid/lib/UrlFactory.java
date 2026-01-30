//package org.mediasoup.droid.lib;
//
//import java.util.Locale;
//
//public class UrlFactory {
//
//  private static final String HOSTNAME = "v3demo.mediasoup.org";
//  //  private static final String HOSTNAME = "192.168.1.103";
//  private static final int PORT = 4443;
//
//  public static String getInvitationLink(String roomId, boolean forceH264, boolean forceVP9) {
//    String url = String.format(Locale.US, "https://%s/?roomId=%s", HOSTNAME, roomId);
//    if (forceH264) {
//      url += "&forceH264=true";
//    } else if (forceVP9) {
//      url += "&forceVP9=true";
//    }
//    return url;
//  }
//
//  public static String getProtooUrl(
//      String roomId, String peerId, boolean forceH264, boolean forceVP9) {
//    String url =
//        String.format(
//            Locale.US, "wss://%s:%d/?roomId=%s&peerId=%s", HOSTNAME, PORT, roomId, peerId);
//    if (forceH264) {
//      url += "&forceH264=true";
//    } else if (forceVP9) {
//      url += "&forceVP9=true";
//    }
//    return url;
//  }
//}


package org.mediasoup.droid.lib;

import java.util.Locale;

public class UrlFactory {

    // 🔴 CHANGE: use your LOCAL server IP
    private static final String HOSTNAME = "172.25.97.125";

    // mediasoup-demo server expects this port
    private static final int PORT = 4443;

    public static String getInvitationLink(String roomId, boolean forceH264, boolean forceVP9) {
        String url = String.format(Locale.US, "http://%s/?roomId=%s", HOSTNAME, roomId);
        if (forceH264) {
            url += "&forceH264=true";
        } else if (forceVP9) {
            url += "&forceVP9=true";
        }
        return url;
    }

    public static String getProtooUrl(
            String roomId, String peerId, boolean forceH264, boolean forceVP9) {

        // 🔴 CHANGE: wss:// ➜ ws:// (NO TLS for local dev)
        String url =
                String.format(
                        Locale.US,
                        "ws://%s:%d/?roomId=%s&peerId=%s",
                        HOSTNAME,
                        PORT,
                        roomId,
                        peerId
                );

        if (forceH264) {
            url += "&forceH264=true";
        } else if (forceVP9) {
            url += "&forceVP9=true";
        }
        return url;
    }
}
