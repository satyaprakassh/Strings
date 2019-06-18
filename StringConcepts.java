/*
To be covered :

1: String class
2: StringBuffer class
3: StringBuilder class



Difference between String & StringaBuffer class :
-------------------------------------------------

1:
--
-Once we create a String object with "new" keyword, then we can't perform any change in the 
existing object. If we try to perform any changes to the existing object then with those
changes a new object will be created. This property of String Object is known as 
immutability.

ex: String s=new String("java");
    s.concat("application");//   there is no effect on object s.
    
    System.out.println(s)// o|p : java

observation: In the first line we have created a String object havaing reference variable s 
and in the second line we are trying to change the content. As String objects are immutable
there is no effect on object s. But, as we have changed content of the object s,another
object was created without any reference variable.



- In case of StringBufer , once we create a StringBufer object , we can perform any change
inn the existing object. This changable behavior of StringBuffer is known as mutability.

ex: StringBuffer sb1=new StringBuffer("java");
    sb1.oppend("application");
    
    System.out.println(sb1)// javaapplication

observation: In the first line we have created StringBuffer obeject and in the second line
we are trying to change the content of the oexisting bject. As StringBuffer is mutable, 
the content of the existing object have been changed.


2:
--

- In String class equals() method is overridden for contenct comparison. If we campare any
two String objects having same content whether both objects are equal or not, then the
equals() method will return true.

ex: String s1=new String("abcd");
    String s2=new String("abcd");
    
    System.out.println(s1.equals(s2);// o|p: true
    

- But in StringBuffer class, equals() method is not overridden, hence when ever we try to 
compare any two StringBuffer objects then Object class equals() method will be executed,
which wil compare in terms of reference comparison.

ex: StringBuffer sb1=new StringBuffer("abcd");
    StringBuffer sb2=new StringBuffer("abcd");
    
    System.out.println(sb1.equals(sb2);// o|p : false
    
note:
-----
- Whenever we try to compare two objects but those two objects are different type, then
JVM will raise error saying : Incomparible type.

ex: String s1=new String("xyz");
    StringBuffer sb1=new StringBuffer("xyz");
    
    System.out.println(s1.equals(sb1));//  error : Incomparible type
*/
/*
class StringConcepts1
{
    public static void main (String[] args)
    {
        // immutability
        String s1=new String("String is Immutable");
        s1.concat("i am trying to change your content");
        
        System.out.println("s1 : "+s1);
        
        StringBuffer sb1=new StringBuffer("StringBuffer is mutable");
        //StringBuffer sb2=new StringBuffer(", So its content can be changed");
        
        sb1.append(", So its content can be changed");
        
        System.out.println("sb1 : "+sb1);
        
        
        // role of equals() method 
        String s2=new String("String is Immutable");
        String s3=new String("its content is different");
        
        System.out.println(s1.equals(s2));//true
        System.out.println(s1.equals(s3));//false
        System.out.println(s1==s2);//false
        System.out.println(s1==s3);//false
        
        
        StringBuffer sb3=new StringBuffer("not depend on content");
        System.out.println(sb1.equals(sb3));
        System.out.println(sb1==sb3);
    }
}*/
/*

Concept of heap and String constant pool(scp) :
-----------------------------------------------
- Heap and scp are the memory management technique used to stored String values 
effectively.

- To interpret this concept lets consider the following statements:

creating String Without new keyword:
------------------------------------
  : String s1="creating String without "new" keyword";
  : String s2="creating String without "new" keyword";
  : String s3="creating  another String without "new" keyword";

- Whenever we create a String object without "new" keyword then that object will be stored
only inside scp area.

-note-
------
-When we create this type of String object then JVM will check whether any existing String
object with same content in present inside the scp area or not. If present then no  new
object will not be created only the reference variables will point to the existing object
and if not then another String object will be created.
- So  reference variables s1 and s2 will point to the same object and for s3 reference
variable, a new object will be created.

- As we are not creaing String object with "new" keyword so those objects are mutable
i.e we can change the content of the existing String object.

ex: String s="zzz";
    s="ppp";
    System.out.println(s);// o|p: ppp
    
creating String object with "new" keyword:
------------------------------------------
  String s1=new String("Immutable");
  String s2=new String("Immutable");
  String s3=new String("content changed");
  
 - When ever we create a String object with "new" keyword,
 : At first step , JVM will check whether  any existing object with same content is 
present inside the scp area or not. If  present then no new object will be created, and 
if not then a new object created inside the scp area. But the reference variable will not
point to that object.
    
 : At the second step, at run time JVM will stored another object inside the heap 
area without checking checking any existing object with same content. I.e. inside the 
heap memory,always new objects are created whether any existing object having same content
or not.

- So inside the heap area, all three objects with their distinct reference variables will
be created and inside scp area, only two object will be stored : one object having content
"Immutable" will be stored and s1 & s2 reference variabless will point to it. another
object having content "content changed" will be created and the s3 reference variable will
point to it.
*/


/*
Pros and cons of scp area & heap area  over heap area:
------------------------------------------------------
pros of scp area over heap area:-

            : We know that when we create a String without "new" keyword then that object
is stored only inside the scp area. In projects, if multiple String objects having same
contents are required, it is not recommended to create separate objects with "new" keyword
because it create performance problem and misutilization of memory.
So, instead of creating separate objects we can create String object without using "new"
keyword so that multiple reference variables will point to the existing object. For that
performance memory utilization will be increased.


cons of scp are over heap area :-

                : But the main cons of scp area is : When multiple reference variables
point to a single object and if we change the content to one reference variable then it
will affect to all reference variables. But in case of heap area such problems will not
occur because inside heap area, distinct objects whether having same or different contents
are stored. If we try to change the content of one reference variable then no other 
reference variables will be affected.

ex:  String s1=new String("aaa");
     String s2=new String("bbb");
     String s3=new Strin("aaa");
     s1="zzz";
     System.out.println(s1);//o|p: zzz
     System.out.println(s2);//o|p: bbb
     System.out.println(s3);//o|p: aaa
     
     
     String s4="ppp";
     String s5="ppp";
     String s6="ppp";
     
     s5="mmm";
     System.out.println(s4);//o|p: mmm
     System.out.println(s5);//o|p: mmm
     System.out.println(s6);//o|p: mmm
    
-note:1-
--------

scp memory is only available/applicable to String objects but not for StringBuffer objects.

- StringBuffer objects are stored only insde the heap memory. So when we try to change
the content of StringBuffer object then its content will be changed but it will not affect
the other StringBuffer objects.

ex: StringBuffer sb1=new StringBuffer("aaa");
    StringBuffer sb2=new StringBuffer("aaa");
    System.out.println(sb1==sb2)// false
    System.out.println(sb1.equals(sb2))// false
    
    sb1.append("www");
    System.outprintln(sb1)// o|P: www
    System.outprintln(sb2)// o|P: aaa

-note:2-
--------
- Whenever we try to change the content using heap object reference variable , because of
immutable property that its content will not changed but a new object will be created 
and that object will be stored only inside heap area but not inside scp area.

ex: String s1=new String("aaa";
    String s2=new String("aaa");
    String s3="aaa";
    
    s1=iii;
    
    


*/
class StringConcepts2
{
    public static void main(String [] args)
    {
        String s1=new String("aaa");
        String s2=new String("aaa");
        String s3="aaa";
        
        s1="iii";
        
        System.out.println(s1==s3);// false
        System.out.println();
        StringBuffer sb1=new StringBuffer("aaa");
        StringBuffer sb2=new StringBuffer("aaa");
        System.out.println(sb1==sb2);// false
        System.out.println(sb1.equals(sb2));// false
        
        
        //sb1="www";//error : incompatible types: String cannot be converted to StringBuffer
        sb1.append("www");
        System.out.println(sb1);// o|P: www
        System.out.println(sb2);// o|P: aaa
        
        
        
         System.out.println();
         String s4=new String("aaa");
         String s5=new String("bbb");
         String s6=new String("aaa");
         s4="zzz";
         System.out.println(s4);//o|p: zzz
         System.out.println(s5);//o|p: bbb
         System.out.println(s6);//o|p: aaa
         
         
         String s7="ppp";
         String s8="ppp";
         String s9="ppp";
         
         s8="mmm";
         System.out.println(s7);//o|p: 
         System.out.println(s8);//o|p: 
         System.out.println(s9);//o|p: 
    
        
    
    }
}