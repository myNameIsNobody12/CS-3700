class Dog extends Animal
{
        private String breed;
        public Dog(String name, int age, String breed)
        {
            super(name,age);
            this.breed = breed;
        }

        public String getBreed()
        {
            return this.breed;
        }

        @Override
        public void makesNoise()
        {
            System.out.println("My dog " + this.getName() + " goes bark!");
        }
}