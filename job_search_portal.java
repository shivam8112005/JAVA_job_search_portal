import java.util.Scanner;
interface utility{
    public void getDetails();
    public void setDetails();
}
class portal implements utility{
    //inherited variable
    static int rec_counter=0;
    String acc_type;

    static int p_counter=0;
    static int com_counter;

    String company_name;
    String name;
    String password;
    String email;
    int age;
    String work;
    String loc;
    String username;
   static int total_jobs;
    Scanner sc=new Scanner(System.in);
    public void getDetails(){
        System.out.println("UserName: "+username);
        System.out.println("Full Name: "+name);
        System.out.println("Age: "+age);
        System.out.println("Location: "+loc);
        System.out.println("Email-Address: "+email);
    }
    public void setDetails(){
        System.out.println("==============================SIGN UP==============================");
        System.out.print("Enter Your Full Name: ");
        name=sc.nextLine();
        System.out.print("Enter Email Address: ");
        boolean b=true;
        while(b){
            email=sc.next();
            int i=email.indexOf("@gmail.com");
            if(email.length()>10){
                ////
                if(i==-1){
                    System.out.println("Enter Valid Email Address!");
                }
               else{
                   b=false;
                }
            }else{
                System.out.println("Enter Valid Email Address!");
            }
        }
        System.out.print("Enter Age: ");
        boolean a=true;
        while(a){
            age= sc.nextInt();
            if(age<18){
                System.out.println("sorry you're under age! ");
                System.exit(0);
                //System.exit(0);
            }if(age>120){
                System.out.println("Enter Valid Age!");
            }
            else{
                a=false;
            }
        }
        String[] un=name.split("\\s+");
        username=un[0]+age;
        System.out.print("Enter your Location:");
        sc.nextLine();
        loc=sc.nextLine();
        System.out.print("Enter Password: ");
        boolean c=true;
        while(c){
            password=sc.next();
            if(password.length()>=8){
                int uc=0;
                int lc=0;
                int sc=0;
                for(int i=0;i<password.length();i++){
                    if(password.charAt(i)>='A' && password.charAt(i)<='Z'){
                        uc++;
                    }else if(password.charAt(i)>='a' && password.charAt(i)<='z'){
                        lc++;
                    }else if(password.charAt(i)=='!' || password.charAt(i)=='~' ||  password.charAt(i)=='@' ||  password.charAt(i)=='#' ||
                            password.charAt(i)=='$' ||  password.charAt(i)=='%' ||  password.charAt(i)=='^' ||  password.charAt(i)=='&' ||
                            password.charAt(i)=='*'){
                        sc++;
                    }
                }if(uc==0){
                    System.out.println("Password Must Contain UpperCase Letters!");
                }
                else if(lc==0){
                    System.out.println("Password Must Contain LowerCase Letters!");
                }else if(sc==0){
                    System.out.println("Password Must Contain Special Characters!");
                }
                else{
                    c=false;
                }
            }else{
                System.out.println("Password Must Be of 8 Characters!");
            }
        }
    }
    void searchpeople(portal[] p,jobseeker1 [] js){
        System.out.println("[1.] Search By Name");
        System.out.println("[2.] Search By Work");
        System.out.println("[3.] Back To Home");
        int choice=sc.nextInt();
        switch(choice){
            case 1:{
                System.out.print("Enter Only First Name Of Person: ");
                String name1=sc.next();
                int a=0;
                for(int i=0;i<p_counter;i++){
                    String[] n=(p[i].name).split("\\s+");
                    if(name1.equalsIgnoreCase(n[0])){
                        p[i].getDetails();
                        js[i].getDetails();
                    }else{
                        a++;
                    }
                }if(a==p_counter){
                    System.out.println("No User Found!");
                }
                searchpeople(p,js);
            }break;
            case 2:{
                System.out.print("Enter Work To Search People: ");
                sc.nextLine();
                String work1=sc.nextLine();
                int a=0;
                for(int i=0;i<p_counter;i++){
                    // String[] n=(p[i].name).split("\\s+");
                    if(work1.equalsIgnoreCase(js[i].work)){
                        p[i].getDetails();
                        js[i].getDetails();
                    }else{
                        a++;
                    }
                }if(a==p_counter){
                    System.out.println("No User Found!");
                }
                searchpeople(p,js);
            }break;
            case 3:{
            }break;
            default:{
                System.out.println("ENTER VALID INPUT!");
                searchpeople(p,js);
            }break;
        }
        ///**ERROR
        //  sc.next();
    }
}class jobseeker1 extends portal implements utility{
    String edu;
    String work1;
    int graduation_year;
    String skills;
    String degree;
    public void getDetails(){
        System.out.println("==============================EDUCATIONAL DETAILS==============================");
        System.out.println("Graduation Status(Student/Graduated): "+work1);
        //inherited variable
        System.out.println("Eduction: "+work);
        System.out.println("College Name: "+edu);
        System.out.println("Graduation Year: "+graduation_year);
        System.out.println("Skills: "+skills);
        System.out.println("Degree Name: "+degree);
    }
    @Override
    public void setDetails() {
        System.out.println("==============================ENTER EDUCATIONAL DETAILS==============================");
        System.out.print("Enter Graduation Status(Student/Graduated): ");
        boolean b=true;
        while(b){
            work1=sc.next();
            if(work1.equalsIgnoreCase("student") ){
                //inherited variable(work)
                System.out.print("Enter Your Highest Education: ");
                sc.nextLine();
                work =sc.nextLine();
                System.out.print("Enter Your College Name: ");
                edu=sc.nextLine();
                System.out.print("Enter Your Graduation Year: ");
                boolean a=true;
                while(a){
                    graduation_year=sc.nextInt();
                    if(graduation_year>=2024 && graduation_year<=2032){
                        a=false;
                    }else{
                        System.out.println("Enter Valid Year!");
                    }
                }
                System.out.print("Enter Your Skills: ");
                sc.nextLine();
                skills=sc.nextLine();
                System.out.print("Enter Your Degree Name: ");
                degree=sc.nextLine();
                b=false;
            } else if(work1.equalsIgnoreCase("graduated")){
                //inherited variable(work)
                System.out.print("Enter Your Work/Enter Your Degree: ");
                sc.nextLine();
                work = sc.nextLine();
                System.out.print("Enter Your College Name: ");
                edu=sc.nextLine();
                System.out.print("Graduated In Year: ");
                boolean a=true;
                while(a){
                    graduation_year=sc.nextInt();
                    if(graduation_year<=2024 ){
                        a=false;
                    }else{
                        System.out.println("Enter Valid Year!");
                    }
                }
                System.out.print("Enter Your Skills: ");
                sc.nextLine();
                skills=sc.nextLine();
                System.out.print("Enter Your Degree Name: ");
                degree=sc.nextLine();
                b=false;
            }else{
                System.out.println("Enter Valid Input!");
            }
        }
    }
}
class company extends recruiter implements utility{
    int est;
    String owner_name;
    String ceo;
    String company_mail;
    public void getDetails(){
        System.out.println("==============================COMPANY DETAILS==============================");
        //inherited variable
        System.out.println("Company Name: "+company_name);
        System.out.println("Email: "+company_mail);


        //inherited variable
        System.out.println("Work of Company: "+work);
        System.out.println("Established in Year: "+est);
        System.out.println("Company Owner: "+owner_name);
        System.out.println("Company CEO: "+ceo);
    }
    public void setDetails(){
        System.out.println("==============================ENTER COMPANY DETAILS==============================");
        //inherited variable
        System.out.print("Enter Company Name: ");

        company_name=sc.nextLine();
        System.out.print("Enter Company's Email Address: ");
        boolean b=true;
        while(b){
            company_mail=sc.next();
            int i=company_mail.indexOf("@gmail.com");
            if(company_mail.length()>10){
                ////
                if(i==-1){
                    System.out.println("Enter Valid Email Address!");
                }
                else if( company_mail.substring(i).equals("@gmail.com")){

                    b=false;
                }
            }else{
                System.out.println("Enter Valid Email Address!");
            }
        }
        //inherited variable(work)
        System.out.print("Enter Work of Company: ");
        sc.nextLine();
        work= sc.nextLine();
        System.out.print("Enter Established Year: ");
        boolean a=true;
        while(a){
            est=sc.nextInt();
            if(est<=2024 && est>=1800){
                a=false;
            }else{
                System.out.println("Enter Valid Year!");
            }
        }
        System.out.print("Enter Owner's Name: ");
        sc.nextLine();
        owner_name=sc.nextLine();
        System.out.print("Enter Name of CEO: ");
        ceo=sc.nextLine();
    }
    void searchcompany(company[] c){
        System.out.println("[1.] Search Company By Company Name");
        System.out.println("[2.] Search Company By Company Work");
        System.out.println("[3.] Back To Home");
        int choice=sc.nextInt();
        switch(choice){
            case 1:{
                System.out.print("Enter Name Of Company You want To Search: ");
                sc.nextLine();
                String companyname=sc.nextLine();
                int a=0;
                for(int i=0;i<com_counter;i++){
                    if(companyname.equalsIgnoreCase(c[i].company_name)){
                        c[i].getDetails();;
                    }else{
                        a++;
                    }
                } if(a==com_counter){
                    System.out.println("No Company Found!");
                }
                searchcompany(c);
            }break;
            case 2:{
                System.out.print("Enter Work To Search Company: ");
                sc.nextLine();
                String companywork=sc.nextLine();
                int a=0;
                for(int i=0;i<com_counter;i++){
                    if(companywork.equalsIgnoreCase(c[i].work)){
                        c[i].getDetails();
                    }else{
                        a++;
                    }
                }if(a==com_counter){
                    System.out.println("No Company Found!");
                }
                searchcompany(c);
            }break;
            case 3:{
            }break;
            default:{
                System.out.println("ENTER VALID INPUT!");
                searchcompany(c);
            }break;
        }
    }
}
class recruiter extends portal{
    String cn;
    String jl;
    String jt;
    String req;
    void addjobs(){
        System.out.print("Enter Company Name: ");
        cn=sc.nextLine();
        System.out.print("Enter Job Title: ");
        jt=sc.nextLine();
        System.out.print("Enter Requirements: ");
        req=sc.nextLine();
        System.out.print("Enter Job Location: ");
        jl=sc.nextLine();
        System.out.println("JOB LISTED SUCCESSFULLY");
        //inherited variable
        total_jobs++;
    }
    void viewjobs(){
        System.out.println("Company Name: "+cn);
        System.out.println("Job Title: "+jt);
        System.out.println("Job Requirements: "+req);
        System.out.println("Job Location: "+jl);
    }
    void searchjob(recruiter[] r){
        System.out.println("[1.] Search By Company Name");
        System.out.println("[2.] Search By Job Title");
        System.out.println("[3.] Search By Job Requirements");
        System.out.println("[4.] Search By Job Location");
        System.out.println("[5.] Back To Home");
        int choice=sc.nextInt();
        switch(choice){
            case 1:{
                System.out.print("Enter Company Name to Search Job: ");
                sc.nextLine();
                String cn1=sc.nextLine();
                int a=0;
                for(int i=0;i<portal.rec_counter;i++){
                    if(cn1.equalsIgnoreCase(r[i].cn)){
                        r[i].viewjobs();

                    }else{
                        a++;
                    }
                }if(a==portal.rec_counter){
                    System.out.println("No Jobs Found in "+cn1);
                }
                searchjob(r);
            }break;
            case 2:{
                System.out.print("Enter Job Title To Search Job: ");
                sc.nextLine();
                String jt1=sc.nextLine();
                int a=0;
                for(int i=0;i<portal.rec_counter;i++){
                    if(jt1.equalsIgnoreCase(r[i].jt)){
                        r[i].viewjobs();
                    }
                    else{
                        a++;
                    }
                }if(a==portal.rec_counter){
                    System.out.println("No Jobs Found For "+jt1);
                }
                searchjob(r);
            }break;
            case 3:{
                System.out.print("Enter Your Skills To Search Job: ");
                sc.nextLine();
                String req1=sc.nextLine();
                int a=0;
                for(int i=0;i<portal.rec_counter;i++){
                    if(req1.equalsIgnoreCase(r[i].req)){
                        r[i].viewjobs();
                    }else{
                        a++;
                    }
                }if(a==portal.rec_counter){
                    System.out.println("No Jobs Found For "+req1+" Skill Set");
                }
                searchjob(r);
            }break;
            case 4:{
                System.out.print("Enter Location To Search Job: ");
                sc.nextLine();
                String loc1=sc.nextLine();
                int a=0;
                for(int i=0;i<portal.rec_counter;i++){
                    if(loc1.equalsIgnoreCase(r[i].jl)){
                        r[i].viewjobs();
                    }else{
                        a++;
                    }
                }if(a==portal.rec_counter){
                    System.out.println("No Jobs Found At "+loc1+" Location");
                }
                searchjob(r);
            }break;
            case 5:{
            }break;
            default:{
                System.out.println("Enter Valid Input!");
                searchjob(r);
            }break;
        }
    }
}
public class job_search_portal {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        portal[] p=new portal[5];
        jobseeker1[] js=new jobseeker1[5];
        int js_counter=0;
        recruiter[] rec=new recruiter[5];
        company[] c=new company[5];
        String acc_type;
        int a=-1;
        if(portal.p_counter<5){
            p[portal.p_counter]=new portal();
            p[portal.p_counter].setDetails();
            System.out.print("Account Type(Jobseeker/Recruiter): ");
            boolean b=true;
            while(b){
                acc_type=sc.next();
                if( acc_type.equalsIgnoreCase("jobseeker")){
                    js[portal.p_counter]=new jobseeker1();
                    js[portal.p_counter].setDetails();
                    portal.p_counter++;
                    a=1;
                    b=false;
                }else if(acc_type.equalsIgnoreCase("recruiter")){
                    //error
                    c[portal.com_counter]=new company();
                    c[portal.com_counter].setDetails();
                    portal.com_counter++;
                    a=0;
                    b=false;
                }else{
                    System.out.println("Enter Valid Input!");
                }
            }
        }else{
            System.out.println("You've Reached Your Limit!");
        }
        while(true){
            if(a==1){
                System.out.println("====================Home Page====================");
                System.out.println("[1.] view jobs");
                System.out.println("[2.] search jobs");
                System.out.println("[3.] search people");
                System.out.println("[4.] Search Company");
                System.out.println("[5.] Create New Account");
                System.out.println("[6.] Exit");
                int choice1=sc.nextInt();
                switch (choice1){
                    case 1:{
                        if(portal.rec_counter==0){
                            System.out.println("==============================NO JOBS LISTED==============================");
                        }
                        else{
                            System.out.println("==============================JOBS LISTINGS==============================");
                            for(int i=0;i<portal.rec_counter;i++){
                                rec[i].viewjobs();
                            }
                        }
                    }break;
                    case 2:{
                        if(portal.rec_counter==0){
                            System.out.println("==============================NO JOBS FOUND==============================");
                        }
                        else{
                            rec[0].searchjob(rec);
                        }
                    }break;
                    case 3:{
                        p[0].searchpeople(p,js);
                    }break;
                    case 4:{
                        if(c[0]!=null){
                            c[0].searchcompany(c);
                        }
                        else{
                            System.out.println("No company listed!");
                        }

                    }break;
                    case 5:{
                        if(portal.p_counter<5){
                            p[portal.p_counter]=new portal();
                            p[portal.p_counter].setDetails();
                            System.out.print("Account Type(Jobseeker/Recruiter): ");
                            boolean b=true;
                            while(b){
                                p[portal.p_counter].acc_type=sc.next();
                                if( p[portal.p_counter].acc_type.equalsIgnoreCase("jobseeker")){
                                    // a=1;
                                    js[portal.p_counter]=new jobseeker1();
                                    js[portal.p_counter].setDetails();
                                    portal.p_counter++;
                                    b=false;
                                }else if( p[portal.p_counter].acc_type.equalsIgnoreCase("recruiter")){
                                    //error
                                    a=0;
                                    c[portal.com_counter]=new company();
                                    c[portal.com_counter].setDetails();
                                    portal.com_counter++;
                                    b=false;
                                }else{
                                    System.out.println("Enter Valid Input!");
                                }
                            }
                        }else{
                            System.out.println("You,ve Reached Your Limit!");
                        }
                        continue;
                    }
                    case 6:{
                        System.exit(0);
                    }break;
                    default:{
                        System.out.println("ENTER VALID INPUT!");
                    }break;
                }
            }
            else {
                System.out.println("====================Home Page====================");
                System.out.println("[1.] add job listings");
                System.out.println("[2.] view jobs");
                System.out.println("[3.] search jobs");
                System.out.println("[4.] search people");
                System.out.println("[5.] Search Company");
                System.out.println("[6.] Create New Account");
                System.out.println("[7.] Exit");
                int choice = sc.nextInt();
                switch (choice) {
                    case 1: {
                        if (portal.rec_counter < 5) {
                            System.out.println("==============================ADD JOBS==============================");
                            rec[portal.rec_counter] = new recruiter();
                            rec[portal.rec_counter].addjobs();
                            portal.rec_counter++;
                        } else {
                            System.out.println("Your Limit of Adding Job is Reached!");
                        }
                    }
                    break;
                    case 2: {
                        if (portal.rec_counter == 0) {
                            System.out.println("==============================NO JOBS LISTED==============================");
                        } else {
                            System.out.println("==============================JOBS LISTINGS==============================");
                            for (int i = 0; i < portal.rec_counter; i++) {
                                rec[i].viewjobs();
                            }
                        }
                    }
                    break;
                    case 3: {
                        if (portal.rec_counter == 0) {
                            System.out.println("==============================NO JOBS FOUND==============================");
                        } else {
                            rec[0].searchjob(rec);
                        }
                    }
                    break;
                    case 4: {
                        p[0].searchpeople(p, js);
                    }
                    break;
                    case 5: {
                        c[0].searchcompany(c);
                    }
                    break;
                    case 6: {
                     //  portal.total_jobs=0;
                        if (portal.p_counter < 5) {
                            p[portal.p_counter] = new portal();
                            p[portal.p_counter].setDetails();

                            System.out.print("Account Type(Jobseeker/Recruiter): ");
                            boolean b = true;
                            while (b) {
                                p[portal.p_counter].acc_type = sc.next();
                                if (p[portal.p_counter].acc_type.equalsIgnoreCase("jobseeker")) {
                                    js[portal.p_counter] = new jobseeker1();
                                    js[portal.p_counter].setDetails();
                                    portal.p_counter++;
                                    a=1;
                                    b = false;
                                } else if (p[portal.p_counter].acc_type.equalsIgnoreCase("recruiter")) {
                                    //error
                                    c[portal.com_counter] = new company();
                                    c[portal.com_counter].setDetails();
                                    portal.com_counter++;
                                    a=0;
                                    b = false;
                                } else {
                                    System.out.println("Enter Valid Input!");
                                }
                            }
                        }else{
                            System.out.println("You,ve Reached Your Limit!");
                        }
                    }
                    break;
                    case 7: {
                        System.exit(0);
                    }
                    break;
                    default: {
                        System.out.println("ENTER VALID INPUT!");
                    }
                    break;
                }
            }
        }
// surround every input with try catch block

    }
}
//finalllllllllllllllllllllllllllllllllllllllllllll