/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package location;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author phang
 */
public class Security {
    @JsonProperty("is_vpn")
    private boolean isVpn;
    public boolean isVpn() {
        return isVpn;
    }
    public void setVpn(boolean vpn) {
        isVpn = vpn;
    }
}
