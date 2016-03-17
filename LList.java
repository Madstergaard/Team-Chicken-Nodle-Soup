/*****************************************************
 * class LList
 * Implements a linked list of LLNodes, each containing String data
 *****************************************************/

public class LList implements List { //your List interface must be in same dir

    //instance vars
    private DLLNode _butt;
    private DLLNode _head;
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) {
	_butt = null;
	_head = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------
    public boolean add( String newVal ) { 
	DLLNode tmp = new DLLNode( newVal, _head,_butt );
	if (_size > 0){
	    _head.setPrev(tmp);}
	_head = tmp;
	_size++;

       return true;
    } 


    //******* inserts a node containing s at position I *******
    public void add( int i, String s ){
	if (i == 0){
	    add(s);}
       	DLLNode dummy = _head;
	DLLNode newNode = new DLLNode(s,null,null);
	for (int n  = 0; n < i - 1 ; n++){
	    dummy = dummy.getNext();
	}

        newNode.setNext(dummy.getNext());
	newNode.setPrev(dummy);
	dummy.setNext(newNode);
	if (dummy.getNext() != null){
	    dummy.getNext().setPrev(newNode);
	}
	
	/* newNode.setNext(dummy);
	newNode.setPrev(dummy.getPrev());
	dummy.setPrev(newNode);
	if (dummy.getPrev() != null){
	    dummy.getPrev().setNext(newNode);
	    }*/
	_size++;
	
    }
	
    	



    //******* removes the node at position i and returns its cargo *******
    public String remove( int i ){
	DLLNode temp = _head;
	for (int j = 0; j < i; j++){
	    temp = temp.getNext();}
	if (i > 0){
	    try {temp.getPrev().setNext(temp.getNext());}
	    catch (NullPointerException e) {}}
	if (i < _size - 1){
	    try {temp.getNext().setPrev(temp.getPrev());}
	    catch (NullPointerException e) {}}
        
	_size += -1;
	return temp.getCargo();
    }
    
    
    public String get( int index ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	String retVal;
	DLLNode tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    } 


    public String set( int i, String s ) { 
        DLLNode temp = _head;
	for (int j = 0; j < i; j++){
	    temp = temp.getNext();}
	DLLNode newNode = new DLLNode(s, temp.getNext(), temp.getPrev());
	temp.getPrev().setNext(newNode);
	temp.getNext().setPrev(newNode);
	return s;
    } 


    //return number of nodes in list
    public int size() { return _size; } 

    //--------------^  List interface methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode tmp = _head; //init tr
	while( tmp != null ) {
	    if (tmp.getNext() != null){
		retStr += tmp.getCargo() + "<->";}
	    else {
		retStr += tmp.getCargo() + "<-";}
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) {
	/*
	LList james = new LList();

	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("beat");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("a");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("need");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	james.add("I");
	System.out.println( james );
	System.out.println( "size: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	james.set( 1, "got" );
	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

	System.out.println( james );
	
	*/
	// ---------------------- v2 additions ---------------------------                      

        List l1 = new LList();
        String[] temp = new String[] {"a","b","c","d","e","f","g","h","i","j","k"};
        for (int i = temp.length - 1; i >= 0; i--){
            l1.add(temp[i]);
            //System.out.println(l1);                                                           
        }

        System.out.print("l1: \t");
        System.out.println(l1);

        System.out.println("--------------------ADDING--------------------");

        l1.add(4,"JOHN CENAAA");
        System.out.println(l1);


        l1.add(0, "add at 0");
	System.out.println(l1);

        l1.add(2, "add at 2");
        System.out.println(l1);

        l1.add(l1.size(), "add at end"); 
        System.out.println(l1);
	
        System.out.println("--------------------REMOVING--------------------");
        l1.remove(1);
        System.out.println(l1);

        l1.remove(0);
        System.out.println(l1);

        l1.remove(4);
        System.out.println(l1);

        l1.remove(l1.size() - 1);
        System.out.println(l1);
    }

}//end class LList



