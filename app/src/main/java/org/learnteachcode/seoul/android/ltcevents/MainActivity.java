package org.learnteachcode.seoul.android.ltcevents;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
/*
    MainActivity is a class. You can think of a class like a blueprint.
    It defines the properties of something and how it should behave.
    An object is like the building constructed from a blueprint. An object
    has all of the properties and methods defined by its class.
    You can think of properties as things the object "knows" and
    methods as things the object "does".

    To define a class, you use the "class" keyword. The name of the file
    should match the name of the class.

    When we say "Momomo extends Mo" we're defining an inheritance
    relationship. In this case, MainActivity is the subclass or child class.
    AppCompatActivity is the superclass or parent class.
    When creating an inheritance relationship, the subclass/child class
    automatically has all of the properties and behaviors defined by
    the parent class. In this case, MainActivity automatically has
    all of the things that AppCompatActivity has.

    You'll notice a { here and a corresponding } later. Everything
    between these {} is said to be "inside" or to "belong" to the class.
 */

    public void buttonClick(View view) {
    /*
        This is how we define a method.

        "public" says that any other class/object can use this method.

        "void" means that the method does not output any data.

        "buttonClick" is the name of the method.

        "View view" is the input the method receives.

        All of the above-mentioned pieces are called
        the "method signature".

        Similar to a class, things between {} belong to the
        method. This is called the "method body".
     */
        Intent gustavo = new Intent(this, DisplayMessageActivity.class);
        /*
            This is defining a variable called "gustavo". Its type is Intent.

            In Java, we store data in "variables". You can think of a
            variable like a box with a label. The label on the box is the
            name: in this case, "gustavo". The box only fits certain
            objects, in this case, an "Intent". In Java, when creating
            a variable, you must specify a type (Intent) and a name (gustavo).

            In Java, the = symbol is used for assignment. What is after
            the = is stored into the variable before the =. In this case,
            "new Intent(this, DisplayMessageActivity.class)" is being
            stored into the gustavo variable.

            The "new" keyword tells Java that we're creating a new object.

            Next, "Intent" is being used to call the Intent class's
            constructor method. Remember the blueprint and building
            metaphor? The constructor method "constructs" the
            building (object) from the blueprint (class).

            The items between () indicate inputs to the Intent constructor.

            "this" is referencing the class we're currently inside (MainActivity).

            "DisplayMessageActivity.class" is referencing a class called
            DisplayMessageActivity, which we've created elsewhere in this project.
         */

        EditText josie = (EditText) findViewById(R.id.editText2);
        /*
            Similar to above, we're defining a new variable named "josie" that is
            an "EditText" type of object.

            findViewById is a method provided by AppCompatActivity. Since
            MainActivity inherits from AppCompatActivity, it's available to us.

            R is referencing resources available to our project, mostly in
            the "res" directory.

            If you look at content_main.xml, there is an editText element
            with an ID of "editText2". This is how we can retrieve that element
            and do things with it in code.

            If you hold Ctrl on Windows or Command on Mac and hover your mouse
            over "findViewById", you'll see its method signature. Notice that
            it outputs/returns a View object, not an EditText object. We can
            store the View object into the EditText object by "casting".
            Casting is when you convert an object of one type into another type.
            Casting cannot be done for all types. For example, casting the
            number 4 as an EditText would not work.

            In this case, findViewById is making use of a property called
            "polymorphism". findViewById returns a View, but thanks to
            polymorphism, it can return any object that inherits from View.
            Why? Inheritance guarantees that subclasses have everything
            that the parent class has. If EditText inherits from View,
            it's guaranteed to have all properties and methods that a View
            has. Due to this, by returning a View, findViewById can
            actually return any object that inherits from View.

            In this case, we know that the editText2 element is actually
            an EditText object. It's just being exposed as a View. Since
            the item is truly an EditText object, we can cast it using
            (EditText). This converts the output of findViewById into
            an object of type EditText, which we can then store into
            our "josie" variable.
         */

        String message = josie.getText().toString();
        gustavo.putExtra("org.learnteachcode.seoul.android.ltcevents.message", message);
        startActivity(gustavo);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
