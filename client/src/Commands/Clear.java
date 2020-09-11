/**
 * Класс команды Clear
 * @author SaintLaurentPrince and Mariec
 * @version 1.0
 */

package Commands;

import Controller.CommandWithoutArg;
import Controller.RouteCollection;

public class Clear implements CommandWithoutArg {
	RouteCollection collection = new RouteCollection();

	@Override
	public String execute(Object o) {
		collection.clear();
		return("Коллекция успешно очищена.");
	}

	@Override
	public String getName() {
		return "clear";
	}
}