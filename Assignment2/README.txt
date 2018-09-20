==============================================================
-- EEET2580 - Enterprise Application Development
-- Assignment 2
-- Student Name: Tran Thi Hong Phuong
-- Student ID: s3623386
-- Date: 19 August, 2018
==============================================================
==============================================================

Webapp URL: ec2-35-162-65-166.us-west-2.compute.amazonaws.com

==============================================================
==============================================================

--------------------------------------------------------------
Disease
--------------------------------------------------------------

POST: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/add-diseases
Body:
{
	"icd": "A01",
	"name": "migraine"
}

GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/diseases
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/diseases/id/19
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/diseases-icd/A0
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/find-disease/fever

PUT: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/update-disease
Body:
{
	"id": 1,
	"name": "fever"
}

DELETE: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/del-disease/27

--------------------------------------------------------------
Drug
--------------------------------------------------------------

POST: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/add-drugs
Body:
{
	"name": "codein"
}

GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/drugs
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/drugs/id/19
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/find-drugs/paracetamol

PUT: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/update-drug
Body:
{
	"id": 100,
	"name": "new drug"
}

DELETE: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/del-drug/27

--------------------------------------------------------------
Patient
--------------------------------------------------------------

POST: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/add-patient
Body:
{
	"name": "Phuong"
	"birthday": "1998-01-19"
	"gender": "Female"
	"address": "Vietnam"
}

GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/patients
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/patients/id/19
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/find-patients-name/Phuong
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/find-patients-birthday/1998

PUT: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/update-patient
Body:
{
	"id": 1,
	"name": "Phuonggg"
}

DELETE: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/del-patient/1

--------------------------------------------------------------
Visit
--------------------------------------------------------------

POST: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/add-visit
Body:
{
	"patient": 1,

	"problems": ["headache", "nausea"],

	"disease": 29,

	"stringTime": "2008-12-19"

}

GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/visits
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/visits/id/1
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/visits-patient/1
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/visits-on-date/2008-12-19
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/visits-per-day

PUT: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/update-visit
Body:
{
	"id": 1,
	"stringTime": "2008-11-15"
}

DELETE: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/del-visit/1

--------------------------------------------------------------
PrescribedDrugs
--------------------------------------------------------------

GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/prescribed-drugs
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/count-prescribed-drugs

--------------------------------------------------------------
Prescription
--------------------------------------------------------------

POST: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/add-prescriptions
Body:
{
	
	"dose": ""
}

GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/prescriptions
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/prescriptions/id/1
GET: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/drugs-prescribed

PUT: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/update-prescription
Body:
{
	"id": 1
}

DELETE: ec2-35-162-65-166.us-west-2.compute.amazonaws.com:8080/hellospringannotation-1.0-SNAPSHOT/del-prescription/1