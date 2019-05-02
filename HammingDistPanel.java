import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public  class HammingDistPanel extends JFrame implements ChangeListener, ActionListener
{	
	private JLabel hammingDistInfo = new JLabel("Enter Hamming Dist: 1");
	
	private JSlider slider = new JSlider(1,4,1);
	
	private JButton stations = new JButton("Show Station");
	private ArrayList <String> stationNames = new ArrayList <String>();
	private JTextArea stationList = new JTextArea(10,15);
	private JScrollPane sp = new JScrollPane(stationList, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	private JLabel compareInfo = new JLabel("Comapare With:");
	private JComboBox<String> dropDown = new JComboBox<String>();
	
	private JButton calculate = new JButton("Calculate HD");
	private JLabel distance0 = new JLabel("Distance 0");
	private JLabel distanceZero = new JLabel("0");
	private JLabel distance1 = new JLabel("Distance 1");
	private JLabel distanceOne = new JLabel("0");
	private JLabel distance2 = new JLabel("Distance 2");
	private JLabel distanceTwo = new JLabel("0");
	private JLabel distance3 = new JLabel("Distance 3");
	private JLabel distanceThree = new JLabel("0");
	private JLabel distance4 = new JLabel("Distance 4");
	private JLabel distanceFour = new JLabel("0");
	
	private JPanel part1 = new JPanel(new GridBagLayout());
	private JPanel partT = new JPanel();
	private GridBagConstraints c = new GridBagConstraints();
	
	private JButton addStation = new JButton("Add Station");
	private JTextField newStation = new JTextField(8);
	private JLabel exists = new JLabel();
	
	private JLabel freeArea = new JLabel("FREE ZONE: You are free to fill this area with a create idea");
	
	private JButton asciiValue = new JButton("Calculate Average");
	private JLabel value = new JLabel("Station's Ascii Average: 0");
	
	private JButton sameAscii = new JButton("Same Ascii");
	private JTextArea sameStations = new JTextArea(10,15);
	private JScrollPane ap = new JScrollPane(sameStations, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
	public HammingDistPanel() throws IOException
	{
		part1.add(hammingDistInfo);
		
		
		slider.addChangeListener(this);
		slider.setMajorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(slider,c);
		
		stations.addActionListener(this);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 2;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(stations, c);
		
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 3;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(sp,c);
		
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 4;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(compareInfo,c);
		
		
		readFile();
		for(int i = 0; i < stationNames.size(); ++i)
		{
		dropDown.addItem(stationNames.get(i));
		}
		dropDown.setSelectedIndex(1);
		dropDown.addActionListener(this);
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 4;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(dropDown,c);
		
		calculate.addActionListener(this);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 5;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(calculate,c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 6;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(distance0,c);
		c.gridx = 1;
		part1.add(distanceZero,c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 7;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(distance1,c);
		c.gridx = 1;
		part1.add(distanceOne,c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 8;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(distance2,c);
		c.gridx = 1;
		part1.add(distanceTwo,c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 9;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(distance3,c);
		c.gridx = 1;
		part1.add(distanceThree,c);
		
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 10;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(distance4,c);
		c.gridx = 1;
		part1.add(distanceFour,c);
		
		addStation.addActionListener(this);
		c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 11;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(addStation,c);
		
		c = new GridBagConstraints();
		c.gridx = 1;
		c.gridy = 11;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(newStation,c);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 11;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(exists,c);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 0;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(freeArea,c);
		
		
		asciiValue.addActionListener(this);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 1;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(asciiValue,c);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 2;
		c.insets = new Insets(1, 1, 50, 1);
		part1.add(value,c);
		
		sameAscii.addActionListener(this);
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 4;
		c.insets = new Insets(1, 1, 1, 1);
		part1.add(sameAscii,c);
		
		c = new GridBagConstraints();
		c.gridx = 2;
		c.gridy = 3;
		part1.add(ap,c);
		
		partT.add(part1);
		this.add(partT, BorderLayout.LINE_START);
		
		this.setTitle("Hamming Distance");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 550);
		this.setVisible(true);
	
	}
	
	
	
	public static void main(String[] args) throws IOException {
		new HammingDistPanel();
	}
	

	public void readFile() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("Mesonet.txt"));
		
		String strg = br.readLine();
		
		while(strg != null)
		{
			stationNames.add(strg);
			strg = br.readLine();
		}
		br.close();
	
	}


	@Override
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		int value = slider.getValue();
		hammingDistInfo.setText("Enter Hamming Dist: " + value);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == stations)
		{
			stationList.setText("");
			for(int i = 0; i < stationNames.size(); ++i)
			{
				HammingDistance a = null;
				try {
					a = new HammingDistance(dropDown.getSelectedItem().toString(), stationNames.get(i));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				if(a.HammingDist() == slider.getValue())
				{
					stationList.append(stationNames.get(i) + "\n");
				}
			}
		}
		else if(e.getSource() == calculate)
		{
			int[] value = {0,0,0,0,0};
			for(int i = 0; i < stationNames.size(); ++i)
			{
				HammingDistance a = null;
				
				try {
					a = new HammingDistance(dropDown.getSelectedItem().toString(), stationNames.get(i));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				if(a.HammingDist() == 0)
				{
					++value[0];
					distanceZero.setText("" + value[0]);
				}
				else if(a.HammingDist() == 1)
				{
					++value[1];
					distanceOne.setText("" + value[1]);
				}
				else if(a.HammingDist() == 2)
				{
					++value[2];
					distanceTwo.setText("" + value[2]);
				}
				else if(a.HammingDist() == 3)
				{
					++value[3];
					distanceThree.setText("" + value[3]);
				}
				else if(a.HammingDist() == 4)
				{
					++value[4];
					distanceFour.setText("" + value[4]);
				}
		
			}
		}
		else if(e.getSource() == addStation)
		{
			ArrayList<String> ab = stationNames;
			
			if(ab.contains(newStation.getText()))
			{
				exists.setText("Station already exist!");
			}
			else if(!((newStation.getText().length()) == 4))
			{
				exists.setText("Invalid Station");
			}
			else
			{
				ab.add(newStation.getText().toUpperCase());
				Collections.sort(ab);
				dropDown.removeAllItems();
				for(int j = 0; j < ab.size(); ++j)
				{
					dropDown.addItem(ab.get(j));
				}
					exists.setText("Successfully Added");
			}
			
		}
		else if(e.getSource() == asciiValue)
		{
			String StID = dropDown.getSelectedItem().toString();
			MesoAscii Asciiavg = new MesoAscii(new MesoStation(StID));
			int AsciiAvg = Asciiavg.calAverage();
			value.setText("Station's Ascii Average: " + AsciiAvg);
		}
		else if(e.getSource() == sameAscii)
		{
			String StID = dropDown.getSelectedItem().toString();
			MesoAscii Asciiavg = new MesoAscii(new MesoStation(StID));
			int AsciiAvg = Asciiavg.calAverage();
			sameStations.setText("");
			for(int i =0; i < stationNames.size(); ++i)
			{
				String newStID = stationNames.get(i);
				MesoAscii Asciiavg2 = new MesoAscii(new MesoStation(newStID));
				int AsciiAv2 = Asciiavg2.calAverage();
				
				if(AsciiAvg == AsciiAv2)
				{
					sameStations.append(stationNames.get(i) + "\n");
				}
				
			}
		}
		
	}
}