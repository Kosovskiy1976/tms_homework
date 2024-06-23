public class ExistSubordinates {

    public boolean existSubordinates (Director director, String name){
        for (Employee employee : director.getSubordinates()){

            if (employee.getName().equals(name)){
                return true;
            }
        }
        for (Employee employee : director.getSubordinates()){
            if (employee.getTitle().equals(Title.DIRECTOR)){

                Director director1 = (Director) employee;
               return (existSubordinates(director1, name));
            }
        }
        return false;
    }
}
