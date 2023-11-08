package Scenes;

import java.util.ArrayList;

import Characters.Alien;
import Characters.Character;
import Objects.Object;


public abstract class Location{
	
	public String name;
	public String description;
	
	public ArrayList<Object> objects;
	public ArrayList<Character> characters;
	public ArrayList<Alien> aliens;
	
}

