package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.ObservableSubwerkzeug;

public class BezahlungsWerkzeug extends ObservableSubwerkzeug
{
    private BezahlungsWerkzeugUI _ui;

    public BezahlungsWerkzeug()
    {
        _ui = new BezahlungsWerkzeugUI();

        registriereUIAktionen();
        _ui.zeigeFenster();
    }

    private void reagiereAufokButton()
    {
        informiereUeberAenderung();
        _ui.schliesseFenster();
    }

    private void reagiereAufAbbruchButton()
    {
        _ui.schliesseFenster();
    }

    //    private int pruefeEingabe(String textfield) throws NumberFormatException
    //    {
    //        textfield = _ui.getbetragField()
    //            .getText();
    //        int zahl = Integer.parseInt(textfield);
    //        return zahl;
    //    }

    public void setGesamtBetrag(int gesamtbetrag)
    {
        _ui.getgesamtNummer()
            .setText(Integer.toString(gesamtbetrag));
        ;
    }

    private boolean istGueltigeEingabe() throws NumberFormatException
    {
        String text = _ui.getbetragField()
            .getText();
        int betrag = Integer.parseInt(text);
        int gesamtbetrag = Integer.parseInt(_ui.getgesamtNummer()
            .getText());

        if (betrag >= gesamtbetrag)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    //    private boolean istGueltigeGesamtBetrag()
    //    {
    //        int gesamtbetrag = Integer.parseInt(_ui.getgesamtNummer()
    //            .getText());
    //        if (gesamtbetrag > 0)
    //        {
    //            return true;
    //        }
    //        else
    //        {
    //            return false;
    //        }
    //    }

    private void berechneRestBetrag()
    {
        int gesamtBetrag = Integer.parseInt(_ui.getgesamtNummer()
            .getText());
        int betrag = Integer.parseInt(_ui.getbetragField()
            .getText());
        int restBetrag = gesamtBetrag - betrag;
        _ui.getRestBetrag()
            .setText(Integer.toString(restBetrag));

    }

    //    private void fuehreZahlvorgangDurch(int num)
    //    {
    //        if (istGueltigeGesamtBetrag() == true && istGueltigeEingabe() == true)
    //        {
    //
    //        }
    //    }

    /**
     * Verbindet die fachlichen Aktionen mit den Interaktionselementen der
     * graphischen Benutzungsoberfläche.
     */
    private void registriereUIAktionen()
    {
        _ui.getOkButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    reagiereAufokButton();
                }
            });

        _ui.getAbbruchButton()
            .addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    reagiereAufAbbruchButton();
                }
            });

        _ui.getbetragField()
            .addKeyListener(new KeyListener()
            {

                @Override
                public void keyTyped(KeyEvent e)
                {

                }

                @Override
                public void keyPressed(KeyEvent e)
                {

                    if (istGueltigeEingabe() == true)
                    {
                        berechneRestBetrag();
                        _ui.getOkButton()
                            .setEnabled(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Error",
                                e.getKeyChar() + "ist falsche Eingabe",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }

                @Override
                public void keyReleased(KeyEvent e)
                {

                }

            });
    }

}
