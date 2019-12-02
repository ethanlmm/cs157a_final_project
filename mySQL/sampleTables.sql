USE `mydb`;

INSERT INTO Visit
VALUES (0001,'01074', 'Sol Badguy','4444', '4-25-2019', '5-29-2019', 'THC', '3', '4', 'V', 'yes', 'T', 'additional questions concerning help');

INSERT INTO Visit
VALUES (0002,'02033', 'Nai Niji','1412', '2-18-2020', '6-13-2020', 'T', '2', '3', 'GS', 'no', 'A', ' ');

INSERT INTO Visit
VALUES (0003,'03045', 'Ky Kiske','1475', '3-10-2019', '3-28-2019', 'TL', '1', '5', 'HA', 'yes', 'C', 'need refill prescription');

INSERT INTO Visit
VALUES (0004,'00012', 'Annie Hise','1324', '3-10-2019', '3-28-2019', 'T', '0', '2', 'GH', 'no', 'E', 'issue with tiredness and fatigue');

INSERT INTO Medicant
VALUES (00004,'Claritin','seasonal allergic rhinitis, chronic idiopathic urticaria','10 mg','Loratadine','antihistamine','tricyclic antihistamine');

INSERT INTO Medicant
VALUES (00012,'Synthroid','hypothyroidism','1.6-200 mcg per day','Levothyroxine sodium','hypothyroidism','thyroid hormone');

INSERT INTO Medicant
VALUES (02033,'Aspirin','vascular, arthritis, pain','50-325 mg per day','Acetylsalicylic acid','anti-inflammatory','acetylsalicylic acid');

INSERT INTO Medicant
VALUES (01074,'Klonopin','seizures, panic','.5-20 mg daily in divided doses','Clonazepam','antiseizure, antipanic','benzodiazepine');

INSERT INTO Medicant
VALUES (03045,'Xanax','','','','','');

INSERT INTO Chemical_Category
VALUES (97543,'benzodiazepine','');

INSERT INTO Chemical_Category
VALUES (03485,'thyroid hormone','');

INSERT INTO Chemical_Category
VALUES (01294,'tricyclic antihistamine','');

INSERT INTO Chemical_Category
VALUES (02104,'glucocorticosteroid','');

INSERT INTO Disease
VALUES (01900,'hypothyroidism','');

INSERT INTO Disease
VALUES (00239,'antihistamine','');

INSERT INTO Disease
VALUES (01205,'anti-inflammatory','');

INSERT INTO Generic
VALUES (04903,'Loratadine','');

INSERT INTO Generic
VALUES (00230,'Acetylsalicylic acid','');

INSERT INTO Generic
VALUES (00037,'Clonazepam','');

INSERT INTO Generic
VALUES (10309,'Bupropion hydrochloride','');

INSERT INTO Pharmachology
VALUES (0004,00012,'.15 mg','','');

INSERT INTO Pharmachology
VALUES (0002,02033,'500mg/dy','2yrs','');

INSERT INTO Pharmachology
VALUES (0001,01074,'.5mg','since 11/01','');
