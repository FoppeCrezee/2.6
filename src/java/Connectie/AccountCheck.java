package Connectie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Foppe Crezee Class is gemaakt voor het valideren van de wachtwoorden
 * en checkt of de user een arts, of een patient is
 */
public class AccountCheck {

    private String vNaam;
    private String ww;
    private Connection con = null;

    /**
     * @param vNaam is het mailadres van de user
     * @param ww is het wachtwoord van de user
     */
    public AccountCheck(String vNaam, String ww) {
        this.vNaam = vNaam;
        this.ww = ww;
        Connectie conn = new Connectie();
        con = conn.connectie();
    }

    /**
     * Valideert het mailadres en het bijbehorende wachtwoord.
     *
     * @return geeft een int terug voor hoe de validatie is verlopen: 1 betekent
     * dat de user is gevalideert en een patient is. 2 betekent dat de user is
     * gevalideert en een arts is. 3 betekent dat het wachtwoord niet klopte. 4
     * betekent dat de user niet is gevonden.
     */
    public int con() {
        String query = "SELECT * FROM user where Emailadres = ?";
        String s = "niks";
        String w = null;
        try {
            PreparedStatement pst;
            pst = con.prepareStatement(query);
            pst.setString(1, vNaam);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                s = rs.getString("Emailadres");
                w = rs.getString("Wachtwoord");
            }
        } catch (NullPointerException | SQLException e) {
        }

        if (s.equals(vNaam)) {
            if (w.equals(ww)) {
                if (checkPatient()) {
                    return 1;
                } else if (checkArts()) {
                    return 2;
                }
            }
            return 3;
        } else {
            return 4;
        }
    }

    /**
     * Checkt of de User nadat deze is gevalideerd in de tabel van patient staat
     *
     * @return true als deze in de tabel van patient staat, false als deze niet
     * in de tabel van patient staat
     */
    public boolean checkPatient() {
        String queryP = "SELECT * FROM patient where Emailadres = ?";
        String email = null;
        try {
            PreparedStatement pst;
            pst = con.prepareStatement(queryP);
            pst.setString(1, vNaam);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                email = rs.getString("Emailadres");
            }
            return email != null;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Checkt of de User nadat deze is gevalideerd in de tabel van arts staat
     *
     * @return true als deze in de tabel van arts staat, false als deze niet in
     * de tabel van arts staat
     */
    public boolean checkArts() {
        String queryA = "SELECT * FROM Arts where Emailadres = ?";
        String email = null;
        try {
            PreparedStatement pst = null;
            pst = con.prepareStatement(queryA);
            pst.setString(1, vNaam);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                email = rs.getString("Emailadres");
            }
            if (email == null) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

}
