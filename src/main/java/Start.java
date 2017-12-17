import controller.Controller;
import model.Client;
import model.Model;
import view.AddClient;
import view.FindClient;
import view.Main;
import view.services.PoolInfo;

public class Start {

    public static void main(String[] args) {

        //new AddClient();
        //new Main();
        //new FindClient();
        //new PoolInfo();

        //new Controller().showApp();

        Model model = new Model();



        for (Client m: model.getDate()
             ) {
            System.out.println(m.getName());
            System.out.println("");
        }



    }
}
