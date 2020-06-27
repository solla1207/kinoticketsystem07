package de.uni_hamburg.informatik.swt.se2.kino.werkzeuge.bezahlung;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BezahlungsWerkzeugUI
{
    private JFrame _window;

    private JButton _AbbruchButton;
    private JButton _okButton;

    private JTextField _betragField;

    private JLabel _gesamtLabel;
    private JLabel _betragLabel;
    private JLabel _restLabel;

    private JLabel _titelLabel;

    private JLabel _gesamtNummer;
    private JLabel _restNummer;

    private JPanel _PreisPanel;
    private JPanel _buttonPanel;

    // private JDialog _dialog;

    public BezahlungsWerkzeugUI()
    {
        _window = new JFrame();

        createButtons();
        createPanels();

        initializeLabels();
        initializeTextField();
        initializePanels();
        setLayoutManager();

    }

    private void setLayoutManager()
    {
        _window.setLayout(new BorderLayout());
        _window.add(_titelLabel, BorderLayout.NORTH);
        _window.add(_PreisPanel, BorderLayout.CENTER);
        _window.add(_buttonPanel, BorderLayout.SOUTH);
    }

    private void initializePanels()
    {
        _PreisPanel.setLayout(new GridLayout(3, 2));
        _PreisPanel.add(_gesamtLabel);
        _PreisPanel.add(_gesamtNummer);
        _PreisPanel.add(_betragLabel);
        _PreisPanel.add(_betragField);
        _PreisPanel.add(_restLabel);
        _PreisPanel.add(_restNummer);

        _buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        _buttonPanel.add(_AbbruchButton);
        _buttonPanel.add(_okButton);

    }

    private void initializeLabels()
    {
        _gesamtLabel = new JLabel("Gesamtbetrag");
        _gesamtLabel.setPreferredSize(new Dimension(90, 90));
        _betragLabel = new JLabel("Betrag");
        _restLabel = new JLabel("Restbetrag");

        _titelLabel = new JLabel("Barzahlung");
        _titelLabel.setPreferredSize(new Dimension(700, 50));

        //übernehmen von PlatzverkaufsWerkzeug
        _gesamtNummer = new JLabel();
        _restNummer = new JLabel();

    }

    private void initializeTextField()
    {
        _betragField = new JTextField();
    }

    private void createButtons()
    {

        _okButton = new JButton("OK");
        _okButton.setPreferredSize(new Dimension(90, 90));

        _AbbruchButton = new JButton("Abbrechen");
        _AbbruchButton.setPreferredSize(new Dimension(90, 90));
    }

    private void createPanels()
    {
        _PreisPanel = new JPanel();
        _buttonPanel = new JPanel();

    }

    public JButton getOkButton()
    {
        return _okButton;
    }

    public JButton getAbbruchButton()
    {
        return _AbbruchButton;
    }

    public JTextField getbetragField()
    {
        return _betragField;
    }

    public JLabel getgesamtNummer()
    {
        return _gesamtNummer;
    }

    public void setgesamtNummer(JLabel label)
    {
        _gesamtNummer = label;
    }

    public JLabel getRestBetrag()
    {
        return _restNummer;
    }

    public void setRestBetrag(JLabel label)
    {
        _restNummer = label;
    }

    public JFrame getWindow()
    {
        return _window;
    }

    /**
     * Zeigt das Fenster an.
     */
    public void zeigeFenster()
    {
        _window.setSize(800, 500);
        _window.setVisible(true);
    }

    /**
     * Schließt das Fenster.
     */
    public void schliesseFenster()
    {
        _window.dispose();
    }

}
