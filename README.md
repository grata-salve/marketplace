<h2>Код для створення таблиць:</h2>

<h3>Таблиця товарів:</h3>
CREATE TABLE  Product(
    <p>id int primary key generated always as identity,</p>
    <p>name varchar(100) not null,</p>
    <p>price float not null check ( price >= 0 ),</p>
    <p>userId int references "user"(id) on delete cascade</p>
);

<h3>Таблиця зареєстрованих користувачів:</h3>
CREATE TABLE "user" (
    <p>id int primary key generated always as identity,</p>
    <p>firstName varchar(100) not null,</p>
    <p>secondName varchar(100) not null,</p>
    <p>amountOfMoney float not null</p>
);
