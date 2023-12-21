import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CAFETERIA extends JFrame implements ActionListener{

    int CantidadMesas,CantidadPro, totalpreciouni;
    int precio = 0;
    String productos [] = {"GASEOSA", "JUGO", "PAPAS FRITAS"};
    int precios [] = {2000,1000,3000};

    int posicionMesa;

    String productoSel, mesaSel;

    JLabel label1 = new JLabel("CANTIDAD DE MESAS: ");

    JLabel label2 = new JLabel("ELIJA EL PRODUCTO: ");

    JLabel label3 = new JLabel("ELIJA LA MESA: ");

    JLabel label4 = new JLabel("CANTIDAD");

    JLabel lblprecio = new JLabel("PRECIO");

    JLabel lblprecionum = new JLabel("$");

    JLabel lblTotprecio = new JLabel("TOT PRECIO");

    JLabel lblTotprecionum = new JLabel("$");

    ImageIcon imagenGaseosa = new ImageIcon("GASEOSA2.png");

    ImageIcon imagenJugo = new ImageIcon("JUGO.png");

    ImageIcon imagenPapa = new ImageIcon("PAPAS.png");

    JLabel lblimagenGaseosa = new JLabel();

    JLabel lblimagenJugo = new JLabel();

    JLabel lblimagenPapa = new JLabel();

    JTextField TcantMesas = new JTextField();

    JSpinner Tcantprodu = new JSpinner();

    JPanel panel = new JPanel();

    JButton Benviar = new JButton("ENVIAR");

    JButton Breiniciar = new JButton("REINICIAR");

    JButton BcobrarP = new JButton("COBRAR PEDIDO");

    JButton BeliminarP = new JButton("ELIMINAR PEDIDO");

    JButton BreporteMesa = new JButton("REPORTE TIENDA");

    JButton BadicionarPro = new JButton("ADICIONAR PRODUCTO");

    JComboBox comboBox1 = new JComboBox(productos);

    JComboBox comboBox2 = new JComboBox();

    JTable tabla = new JTable();



    public CAFETERIA()
    {
        setSize(600,800); // Establecemos tamaño
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cierra programa
        setTitle("CAFETERIA"); // Titulo de la ventana
        setLocationRelativeTo(null); // centra la ventana
        setResizable(false);


        Benviar.addActionListener(this);
        Breiniciar.addActionListener(this);
        BadicionarPro.addActionListener(this);
        BeliminarP.addActionListener(this);
        BreporteMesa.addActionListener(this);
        BcobrarP.addActionListener(this);
        panel.setLayout(null);
        this.getContentPane().add(panel);

        label1.setBounds(10,0,140,20);
        panel.add(label1);

        label2.setBounds(10,40,180,20);
        panel.add(label2);

        label3.setBounds(450,40,180,20);
        panel.add(label3);

        label4.setBounds(10,100,180,20);
        panel.add(label4);

        lblprecio.setBounds(300,100,180,20);
        panel.add(lblprecio);

        lblprecionum.setBounds(350,100,180,20);
        panel.add(lblprecionum);
        ///

        lblTotprecio.setBounds(300,120,180,20);
        panel.add(lblTotprecio);

        lblTotprecionum.setBounds(380,120,180,20);
        panel.add(lblTotprecionum);

        lblimagenGaseosa.setBounds(150,190,120,150);
        lblimagenGaseosa.setIcon(new ImageIcon(imagenGaseosa.getImage().getScaledInstance(120,150, Image.SCALE_SMOOTH)));
        panel.add(lblimagenGaseosa);

        lblimagenJugo.setBounds(260,190,140,150);
        lblimagenJugo.setIcon(new ImageIcon(imagenJugo.getImage().getScaledInstance(140,150, Image.SCALE_SMOOTH)));
        panel.add(lblimagenJugo);

        lblimagenPapa.setBounds(400,210,120,120);
        lblimagenPapa.setIcon(new ImageIcon(imagenPapa.getImage().getScaledInstance(120,120, Image.SCALE_SMOOTH)));
        panel.add(lblimagenPapa);


        TcantMesas.setBounds(150,0,25,20);
        panel.add(TcantMesas);

        SpinnerModel sp = new SpinnerNumberModel(0,0,20,1);
        Tcantprodu.setBounds(80,100,40,30);
        Tcantprodu.setModel(sp);
        panel.add(Tcantprodu);

        Benviar.setBounds(180,0,80,20);
        panel.add(Benviar);

        Breiniciar.setBounds(270,0,100,20);
        Breiniciar.setEnabled(false);
        panel.add(Breiniciar);

        BcobrarP.setBounds(30,600,150,40);
        BcobrarP.setEnabled(false);
        panel.add(BcobrarP);

        BeliminarP.setBounds(190,600,150,40);
        BeliminarP.setEnabled(false);
        panel.add(BeliminarP);

        BreporteMesa.setBounds(350,600,200,40);
        BreporteMesa.setEnabled(false);
        panel.add(BreporteMesa);

        BadicionarPro.setBounds(10,160,200,40);
        BadicionarPro.setEnabled(false);
        panel.add(BadicionarPro);

        comboBox1.setBounds(10,60,180,20);
        comboBox1.setEnabled(false);
        panel.add(comboBox1);

        comboBox2.setBounds(400,60,180,20);
        comboBox2.setEnabled(false);
        panel.add(comboBox2);

        tabla.setBounds(45,320,500,250);
        panel.add(tabla);

    }

    public void llenarCombox(){

        String [] mesas = new String[CantidadMesas];
        for (int i = 0;i < CantidadMesas; i++)
        {
            mesas[i] = ("MESA " + (i+1));

        }

        DefaultComboBoxModel modeloCbx = new DefaultComboBoxModel(mesas);
        comboBox2.setModel(modeloCbx);

    }

    public void llenartabla()
    {
        Object[][] datos = new Object[CantidadMesas][productos.length + 1];

        for (int i = 0; i < CantidadMesas; i++) {
            // Agregamos el número de mesa en la primera columna
            datos[i][0] = "MESA " + (i+1);
            // Agregamos la cantidad de cada producto en las columnas siguientes
            for (int j = 0; j < productos.length; j++) {
                datos[i][j+1] = 0; // Inicializamos la cantidad en cero
            }
        }

        // Creamos el modelo de tabla con el arreglo de datos y los nombres de las columnas
        DefaultTableModel modeloTabla = new DefaultTableModel(datos,
                new String[]{"MESA", "GASEOSA", "JUGO", "PAPAS FRITAS"});
        tabla.setModel(modeloTabla);

    }

    public void actionPerformed(ActionEvent e)
    {
        JButton fb = (JButton) e.getSource();

        if (fb == Benviar){
            try {
                BadicionarPro.setEnabled(true);
                comboBox1.setEnabled(true);
                comboBox2.setEnabled(true);
                CantidadMesas = Integer.parseInt(TcantMesas.getText());
                Benviar.setEnabled(false);
                TcantMesas.setEnabled(false);
                Breiniciar.setEnabled(true);
                llenarCombox();
                llenartabla();

            }catch (NumberFormatException nfe)
            {
                JOptionPane.showMessageDialog(null,"POR " +
                        "FAVOR DIGITE UN NUMERO");
            }

        }
        if (fb == Breiniciar){

            comboBox1.setEnabled(true);
            comboBox2.setEnabled(true);
            BadicionarPro.setEnabled(false);
            comboBox1.setEnabled(false);
            comboBox2.setEnabled(false);
            BcobrarP.setEnabled(false);
            BreporteMesa.setEnabled(false);
            BeliminarP.setEnabled(false);
            CantidadMesas = 0;
            CantidadMesas = Integer.parseInt(TcantMesas.getText());
            Benviar.setEnabled(true);
            TcantMesas.setEnabled(true);
            Breiniciar.setEnabled(false);
            TcantMesas.setText("");
            comboBox2.removeAllItems();
        }

        if (fb == BcobrarP)
        {
            int filaSeleccionada = tabla.getSelectedRow();
            String mesaSelecion = tabla.getValueAt(filaSeleccionada, 0).toString();
            int cantidadProducto1 = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 1).toString());
            int cantidadProducto2 = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 2).toString());
            int cantidadProducto3 = Integer.parseInt(tabla.getValueAt(filaSeleccionada, 3).toString());

            int PagarGaseosa = cantidadProducto1 * 2000;
            int PagarJugo = cantidadProducto2 * 1000;
            int PagarPapa = cantidadProducto3 * 3000;
            int totalPagar = (PagarGaseosa + PagarJugo + PagarPapa);

            if (cantidadProducto1 == 0 & cantidadProducto2 == 0 & cantidadProducto3 == 0 )
            {
                JOptionPane.showMessageDialog(null,"¡ERROR!" + "\n" + "La mesa seleccionada no tiene una orden");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"MESA: " + mesaSelecion + "\n" +
                        "Cantidad Gaseosa:" + cantidadProducto1 + "  $" + PagarGaseosa + "\n" +
                        "Cantidad Jugo:" + cantidadProducto2 + "  $" + PagarJugo + "\n" +
                        "Cantidad Papas Fritas:" + cantidadProducto3 + "  $" + PagarPapa + "\n" +
                        "TOTAL A PAGAR:  $" + totalPagar );

            }
            int row = tabla.getSelectedRow();
            tabla.setValueAt(0, row, 1);
            tabla.setValueAt(0, row, 2);
            tabla.setValueAt(0, row, 3);

        }

        if (fb == BadicionarPro)
        {
            BcobrarP.setEnabled(true);
            BreporteMesa.setEnabled(true);
            BeliminarP.setEnabled(true);
            int index = comboBox1.getSelectedIndex();
            productoSel = productos[index];
            mesaSel = comboBox2.getSelectedItem().toString();
            posicionMesa = comboBox2.getSelectedIndex();
            int cantidadProd = (int) Tcantprodu.getValue();
            int precioProd = precios[index];
            int totalPrecio = cantidadProd * precioProd;
            tabla.setValueAt(cantidadProd, posicionMesa, index+1);
            precio = precio + totalPrecio;

        }
        if (fb == BeliminarP){
            int row = tabla.getSelectedRow();
            tabla.setValueAt(0, row, 1);
            tabla.setValueAt(0, row, 2);
            tabla.setValueAt(0, row, 3);
        }

        if (fb == BreporteMesa)
        {
            // Obtener el total de ventas
            int totalVentas = 0;
            for (int i = 0; i < CantidadMesas; i++) {
                for (int j = 0; j < productos.length; j++) {
                    int cantidad = Integer.parseInt(tabla.getValueAt(i, j+1).toString());
                    totalVentas += cantidad * precios[j];
                }
            }

            // Calcular los ingresos promedio por mesa
            double ingresosPromedio = (double) totalVentas / CantidadMesas;

            // Encontrar el producto más vendido
            int[] cantidades = new int[productos.length];
            for (int i = 0; i < CantidadMesas; i++) {
                for (int j = 0; j < productos.length; j++) {
                    int cantidad = Integer.parseInt(tabla.getValueAt(i, j+1).toString());
                    cantidades[j] += cantidad;
                }
            }
            int masVendido = 0;
            for (int i = 1; i < productos.length; i++) {
                if (cantidades[i] > cantidades[masVendido]) {
                    masVendido = i;
                }
            }
            // Muestra la información en pantalla
            String mensaje = "Total de ventas: $" + totalVentas + "\n";
            mensaje += "Ingresos promedio por mesa: $" + String.format("%.2f", ingresosPromedio) + "\n";
            mensaje += "Producto más vendido: " + productos[masVendido] + "\n";
            JOptionPane.showMessageDialog(null, mensaje);

        }
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                precio = precios[comboBox1.getSelectedIndex()];
                lblprecionum.setText("$"+precio);


            }
        });
        Tcantprodu.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                CantidadPro = Integer.parseInt(Tcantprodu.getValue().toString());
                totalpreciouni = precio*CantidadPro;
                lblTotprecionum.setText("$"+totalpreciouni);
            }
        });

    }
    public static void main(String[] args)
    {
        CAFETERIA cafeteria = new CAFETERIA();
        cafeteria.setVisible(true);

    }




}
