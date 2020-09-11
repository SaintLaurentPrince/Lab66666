/**
 * Класс команды Exit
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;

import java.io.FileNotFoundException;
import java.util.Scanner;


public class Exit implements CommandWithoutArg {

	@Override
	public String execute(Object o) throws FileNotFoundException {
		System.exit(0);
		return  null;
	}

	@Override
	public String getName() {
		return "exit";
	}
}
