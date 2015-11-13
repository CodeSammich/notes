#Aim: Inserting Python into HTML

* we use jinja 2 template designer
* Essentially HTML, but somewhere in there, there is a special variable,  if {{number}} was the special variable
  - Example on class code.

* Use dictionary, is easier, can put anything as key to get out a value.
 * ex:
  * `d={}`  
    d = a variable  
     ex: [  
      ] = 12345  
	   d.has_key example in template  
	    Look up flask or jinja for other variables, each has different brackets  
	    ` <lastName> (...)`  
		`  for x in d`

* Can also use list, example in template

`return render_template("<name>.html", number = n, string = "")`
 - number is special variable


###REQUESTS
	* get request, puts request into web address to "get" that page
	* `methods = ["GET", "POST"]` allows you to do both get and post requests

	* Get request puts it in url
	* Post request gets it from a form (?)

###MODULES
* don't want everything in `app.py`
  * make new python files to have "module", with more detailed definitions
   * Ex. `utils.py` with one definition:

		def authenticate():
			return wee

- In main `app.py` file:
	 `import utils   #looks in current directory to find file`

	 `utils.authenticate()`

* In Jinja:

		{% if <variable> %}
			<do something>
			{% endif %}
			
 - if `<variable>` EXISTS, Jinja will take it as a `True`, otherwise `False`, can be used in conjunction with
  - Python if/else statements


 `from flask import Markup`
     * if code is safe (HTML), then you can say
     * check Z's code and check out the Markup
