

CREATE TABLE tbPatient(
    PatientID INT IDENTITY(1,1) PRIMARY KEY,
    NameEN NVARCHAR(50) NOT NULL ,
    NameKH NVARCHAR(50) NOT NULL ,
    Sex VARCHAR(5) NOT NULL ,
    BirthDate DATE NOT NULL ,
    Contact NVARCHAR(20) NOT NULL ,
    Address NVARCHAR(20) NOT NULL ,
    MedicalHistory NVARCHAR(MAX)
);

CREATE TABLE tbEmployee(
    EmployeeID INT IDENTITY(1,1) PRIMARY KEY,
    NameEN NVARCHAR(50) NOT NULL ,
    NameKH NVARCHAR(50) NOT NULL ,
    Sex VARCHAR(5) NOT NULL ,
    BirthDate DATE NOT NULL ,
    StaffPosition NVARCHAR(20) NOT NULL ,
    Contact NVARCHAR(20) NOT NULL ,
    Address NVARCHAR(20) NOT NULL ,
    Salary DECIMAL NOT NULL ,
    HireDate DATE NOT NULL ,
    Photo NVARCHAR(100) DEFAULT NULL,
    StoppedWork BIT DEFAULT 1
);

CREATE TABLE tbDoctor(
    DoctorID INT IDENTITY(1,1) PRIMARY KEY,
    NameEN NVARCHAR(50) NOT NULL ,
    NameKH NVARCHAR(50) NOT NULL ,
    Sex VARCHAR(5) NOT NULL ,
    Email NVARCHAR(50) NOT NULL ,
    Address NVARCHAR(50) NOT NULL ,
    Contact NVARCHAR(20) NOT NULL ,
    BirthDate DATE NOT NULL ,
    Specialist NVARCHAR(20) NOT NULL
);

CREATE TABLE tbMedicine(
    MedicineID INT IDENTITY(1,1) PRIMARY KEY,
    BrandName VARCHAR(100) NOT NULL ,
    MedName VARCHAR(100) NOT NULL ,
    Price MONEY,
    Unit NVARCHAR(50) NOT NULL ,
    Quantity FLOAT NOT NULL ,
    ExpireDate DATE NOT NULL
);

CREATE TABLE tbRoom(
    RoomID INT IDENTITY(1,1) PRIMARY KEY,
    BedNumber TINYINT NOT NULL ,
    MaxCapacity INT NOT NULL ,
    CurrentOccupancy INT NOT NULL ,
    Status VARCHAR(30) NOT NULL ,
    Price MONEY
);

CREATE TABLE tbRoomAssign(
    AssignID INT IDENTITY(1,1) PRIMARY KEY,
    PatientID INT,
    FOREIGN KEY (PatientID) REFERENCES tbPatient(PatientID),
    RoomID INT,
    FOREIGN KEY (RoomID) REFERENCES tbRoom(RoomID),
    AdmissionDate DATETIME DEFAULT NULL,
    DischargeDate DATETIME DEFAULT NULL
);

CREATE TABLE tbAppointment(
    AppointmentID	INT IDENTITY(1,1) PRIMARY KEY,
    AppointmentDate	DATE NOT NULL ,
    Description	NVARCHAR(MAX),
    AppointmentType	VARCHAR(50) NOT NULL ,
    PatientID INT,
    FOREIGN KEY (PatientID) REFERENCES tbPatient(PatientID),
    DoctorID INT,
    FOREIGN KEY (DoctorID) REFERENCES tbDoctor(DoctorID),
);

CREATE TABLE tbTreatment(
    TreatmentID INT IDENTITY(1,1) PRIMARY KEY,
    PatientID INT,
    FOREIGN KEY (PatientID) REFERENCES tbPatient(PatientID),
    DoctorID INT,
    FOREIGN KEY (DoctorID) REFERENCES tbDoctor(DoctorID),
    TreatmentDateTime DATE NOT NULL ,
    TreatmentType NVARCHAR(50),
    Description	NVARCHAR(MAX),
);

CREATE TABLE tbMedicalRecord(
    MRID INT IDENTITY(1,1) PRIMARY KEY,
    PatientID INT,
    FOREIGN KEY (PatientID) REFERENCES tbPatient(PatientID),
    DoctorID INT,
    FOREIGN KEY (DoctorID) REFERENCES tbDoctor(DoctorID),
    Examination VARCHAR(255) NOT NULL ,
    Diagnosis VARCHAR(255) NOT NULL ,
    TreatmentID INT,
    FOREIGN KEY (TreatmentID) REFERENCES tbTreatment(TreatmentID),
    Description	NVARCHAR(MAX),
);

CREATE TABLE tbPayment(
    PaymentID INT IDENTITY(1,1) PRIMARY KEY,
    PayDate DATE NOT NULL ,
    PaidAmount DECIMAL NOT NULL ,
    PatientID INT,
    FOREIGN KEY (PatientID) REFERENCES tbPatient(PatientID),
    EmployeeID INT,
    FOREIGN KEY (EmployeeID) REFERENCES tbEmployee(EmployeeID),
);

CREATE TABLE tbInvoice(
    InvoiceID INT IDENTITY(1,1) PRIMARY KEY,
    InvoiceDate DATE NOT NULL ,
    TotalAmount DECIMAL NOT NULL ,
    PaidAmount DECIMAL NOT NULL ,
    PatientID INT,
    FOREIGN KEY (PatientID) REFERENCES tbPatient(PatientID),
    EmployeeID INT,
    FOREIGN KEY (EmployeeID) REFERENCES tbEmployee(EmployeeID),
);

CREATE TABLE tbTreatmentDetail(
    TreatmentID INT,
    MedicineID INT,
    PRIMARY KEY (TreatmentID,MedicineID),
    FOREIGN KEY (TreatmentID) REFERENCES tbTreatment(TreatmentID),
    FOREIGN KEY (MedicineID) REFERENCES tbMedicine(MedicineID),
    Description	NVARCHAR(MAX),
    Quantity INT,
    Unit NVARCHAR(50),
);

CREATE TABLE tbUser(
    UserID INT IDENTITY(1,1) PRIMARY KEY,
    Username NVARCHAR(100) NOT NULL ,
    Email NVARCHAR(40) NOT NULL UNIQUE ,
    Password NVARCHAR(100) NOT NULL ,
    UserType NVARCHAR(100) NOT NULL ,
    Status BIT DEFAULT 1,
    EmployeeID INT,
    FOREIGN KEY (EmployeeID) REFERENCES tbEmployee(EmployeeID),
);