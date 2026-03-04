public abstract class TextBook extends Book {
    private int edition;


    public TextBook(int edition,String isbn,String title){
        super(isbn,title);
        this.edition=edition;
    }



    public void setEdition(int edition) {
        this.edition = edition;
    }

    public String showOrdinalNumber(){
        if (this.edition==11||this.edition==12||this.edition==13){
            return this.edition+"th";
        }
        else if((this.edition-1)%10==0){
            return this.edition+"st";
        }
        else if ((this.edition-2)%10==0){
            return this.edition+"nd";
        }
        else if ((this.edition-3)%10==0){
            return this.edition+"rd";
        }
        else{
            return this.edition+"th";
        }
    }

    @Override
    public boolean checkIsbn(){
        String firstHaft = getIsbn().substring(0,4);
        String secondHaft = getIsbn().substring(4);
        boolean checked = true;
        for(int i = 0; i < secondHaft.length();){
            if(!Character.isDigit(secondHaft.charAt(i))){
                return false;
            }
            i++;
        }
        if (!firstHaft.equalsIgnoreCase("isbn")){
            return false;
        }
        return true;
    }

    @Override
    public String titleFormat(){
        String[] title = getTitle().split(" ");
        String FormatedTitle = "";
        for(int i = 0; i < title.length;){
            title[i] = title[i].substring(0,1).toUpperCase()+title[i].substring(1);
            i++;
        }
        for(int i = 0; i < title.length;){
            FormatedTitle = FormatedTitle +" ";
            i++;
        }
        return FormatedTitle.trim();
    }


    public String toString() {
        return getIsbn()+","+ titleFormat()+","+ this.edition;
    }
}
