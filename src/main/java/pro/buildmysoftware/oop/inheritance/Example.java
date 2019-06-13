package pro.buildmysoftware.oop.inheritance;

public class Example {
	public static void main(String[] args) {
		// Darth Sidious
		Sith darthSidious = new Sith();
		darthSidious.useDarkSidePowers();
		darthSidious.useNeutralPowers();
		// Yoda
		Jedi yoda = new Jedi();
		yoda.useLightSidePowers();
		yoda.useNeutralPowers();

		// so far so good...

		// Mace Windu
		// Now, some sources say Windu actually knows how to use both
		// dark side and light side powers... So, how can we express
		// this?
		Sith sithMaceWindu = new Sith();
		sithMaceWindu.useDarkSidePowers();
		// Unfortunately, this won't work :(
		// sithMaceWindu.useLightSidePowers();
		Jedi jediMaceWindu = new Jedi();
		jediMaceWindu.useLightSidePowers();
		// Unfortunately, this won't work also :(
		// jediMaceWindu.useDarkSidePowers();

		// So, using only inheritance it's impossible for a force
		// user to use both Light Side and Dark Side powers... What a
		// shame :(. Multiple inheritance in Java is prohibited.

		// Instead, we could overcome this limitation by using
		// composition

		// Also, there's another problem with inheritance - we are
		// simply afraid of changing anything in the base class
		// (because all the other classes heavily depend on it).
		// Also, overriding methods in child classes is risky as well.
	}
}
