import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class getBattery {
    public static void main(String[] args) {
        int porcentagemInical = 50;
        int porcentagemMaxima = 100;
        int numeroDeEventos;
        int porcentagemAtual = 0;
        int totalBateria;

        JOptionPane.showMessageDialog(null, "Iniciando o algoritmo getBattery");
        String quantEventos = JOptionPane.showInputDialog(null,"Quantos eventos de carga e descarga da bateria ocorreram?");
        numeroDeEventos = Integer.parseInt(quantEventos);
        int[] listaDeEventos = new int[numeroDeEventos];
        int tempoEvento;


        for (int i = 0; i < listaDeEventos.length; i++) {
            String evento = JOptionPane.showInputDialog(null, "Digite o tempo, em minutos, do evento realizado abaixo."+
                    "\nSe for carregando, apenas digite o tempo"+
                    "\nSe for jogando, coloque um '-' na frente dos minutos");
            tempoEvento = Integer.parseInt(evento);
            listaDeEventos[i] = tempoEvento;
            System.out.println(listaDeEventos[i]);
        }

        porcentagemAtual = porcentagemInical;
        for(int i = 0; i < listaDeEventos.length; i++) {
            porcentagemAtual += listaDeEventos[i];
        }

        if (porcentagemAtual>=porcentagemMaxima) {
            JOptionPane.showMessageDialog(null, "Carga da bateria = 100%");
        } else if (porcentagemAtual< 0) {
            JOptionPane.showMessageDialog(null, "Carga da bateria = 0%");
        } else{
            JOptionPane.showMessageDialog(null, "Carga da bateria = "+(porcentagemAtual)+"%");
        }

    }
}
