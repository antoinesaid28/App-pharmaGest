// import java.awt.AWTException;
// import java.awt.CheckboxMenuItem;
// import java.awt.Frame;
// import java.awt.Image;
// import java.awt.Menu;
// import java.awt.MenuItem;
// import java.awt.PopupMenu;
// import java.awt.SystemTray;
// import java.awt.TrayIcon;
// import java.awt.image.BufferedImage;
// import java.io.IOException;
// import javax.imageio.ImageIO;

// public class TrayIconExample {

// public static void main(String[] args) throws IOException {

// /*
// * Il vous faut une fenêtre pour que l'icône reste active dans la zone de
// * notification Vous pouvez choisir de ne pas afficher la fenêtre
// */
// Frame frame = new Frame();

// /* Vérifie si l'OS supporte la zone de notification */
// if (!SystemTray.isSupported()) {
// System.out.println("SystemTray is not supported");
// return;
// }

// /* Création du menu popup */
// PopupMenu popup = new PopupMenu();

// /* Création du menu Statut */
// Menu statutMenu = new Menu("Statut");
// /* Création des sous menus statut (case à cocher) */
// CheckboxMenuItem activeStatutItem = new CheckboxMenuItem("Actif", true);
// CheckboxMenuItem awayStatutItem = new CheckboxMenuItem("Absent");
// CheckboxMenuItem doNotDisturbItem = new CheckboxMenuItem("Ne pas déranger");
// CheckboxMenuItem invisibleStatutItem = new CheckboxMenuItem("Invisible");

// /* Création du menu Ouvrir */
// MenuItem openItem = new MenuItem("Ouvrir");

// /* Création du menu Se déconnecter */
// MenuItem disconnectItem = new MenuItem("Se déconnecter");

// /* Création du menu Quitter */
// MenuItem exitItem = new MenuItem("Quitter");

// /* Ajoute les sous-menus au menu Statut */
// popup.add(statutMenu);
// statutMenu.add(activeStatutItem);
// statutMenu.add(awayStatutItem);
// statutMenu.add(doNotDisturbItem);
// statutMenu.add(invisibleStatutItem);

// /* Ajoute tous les menus principaux au menu popup */
// popup.add(openItem);
// popup.addSeparator(); // Séparateur de menu __________
// popup.add(disconnectItem);
// popup.addSeparator(); // Séparateur de menu __________
// popup.add(exitItem);

// /* Récupère l'image */
// BufferedImage trayIconImage =
// ImageIO.read(Main.class.getResource("images/icon.png"));
// int trayIconWidth = new TrayIcon(trayIconImage).getSize().width;

// /* Création de l'icône */
// TrayIcon trayIcon = new
// TrayIcon(trayIconImage.getScaledInstance(trayIconWidth, -1,
// Image.SCALE_SMOOTH));
// trayIcon.setPopupMenu(popup);

// /* récupère la zone de notification */
// SystemTray tray = SystemTray.getSystemTray();
// try {
// /* Affiche l'icone dans la zone de notification */
// tray.add(trayIcon);
// } catch (AWTException e) {
// System.out.println("TrayIcon could not be added.");
// }

// }

// }