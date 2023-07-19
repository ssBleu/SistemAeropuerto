package Vista;

import Modelo.DAO.AerolineaDAO;
import Modelo.DAO.AvionDAO;
import Modelo.DAO.PasajeroDAO;
import Modelo.DAO.ReservaDAO;
import Modelo.DAO.TrabajadorDAO;
import Modelo.DAO.VueloDAO;

public class Controladores {

    public static PasajeroDAO objPS = new PasajeroDAO();
    public static AerolineaDAO objAD = new AerolineaDAO();
    public static TrabajadorDAO objTR = new TrabajadorDAO();
    public static AvionDAO objAvD = new AvionDAO();
    public static VueloDAO objVD = new VueloDAO();
    public static ReservaDAO objRS = new ReservaDAO();
}
