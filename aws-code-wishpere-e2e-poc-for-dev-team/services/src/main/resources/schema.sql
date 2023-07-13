-- Create users table
CREATE TABLE "Users" (
	"user_id"	INTEGER,
	"user_name"	VARCHAR(50),
	"email"	VARCHAR(50),
	"qualification"	VARCHAR(50),
	"resume"	LONGBLOB,
	"password"	VARCHAR(50),
	"skill"	VARCHAR(5000),
	PRIMARY KEY("user_id" AUTOINCREMENT)
);

-- Create Jobs table
CREATE TABLE "Jobs" (
	"job_id"	INTEGER,
	"job_title"	VARCHAR(100),
	"job_skills"	VARCHAR(100),
	"job_description"	TEXT,
	"company"	VARCHAR(100),
	"location"	VARCHAR(100),
	"img"	VARCHAR(5000),
	PRIMARY KEY("job_id" AUTOINCREMENT)
)
-- Create Applications table
CREATE TABLE "Applications" (
	"application_id"	INTEGER,
	"user_id"	INTEGER,
	"job_id"	INTEGER,
	"applied_at"	DATETIME DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY("user_id") REFERENCES "Users"("user_id"),
	FOREIGN KEY("job_id") REFERENCES "Jobs"("job_id"),
	PRIMARY KEY("application_id" AUTOINCREMENT)
);

-- Insert sample data into Jobs table
INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('Software Engineer', 'Java, C++, SQL', 'We are seeking a skilled software engineer, As a Software Engineer, you will be responsible for developing and maintaining high-quality software applications. You will collaborate with cross-functional teams to design and implement solutions, write clean code, conduct thorough testing, and stay updated with emerging technologies. ', 'ABC Technologies', 'New York');

INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('Data Analyst', 'SQL, Python, Data Visualization', 'We are looking for a data analyst, As a Data Analyst, you should have a strong analytical mindset, attention to detail, and the ability to communicate complex findings in a clear and concise manner. You will play a vital role in helping the organization make data-informed decisions, optimize processes, and drive business success through data analysis.', 'XYZ Company', 'San Francisco');

INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('Web Developer', 'HTML, CSS, JavaScript', 'We are seeking a talented web developer, As a Web Developer, you will be responsible for designing and building visually appealing and functional websites. You will collaborate with clients and stakeholders to understand their requirements, use your coding skills to develop responsive web pages, and ensure cross-browser compatibility and optimal user experience. Additionally, you will stay updated with the latest web development trends and technologies to deliver modern and innovative web solutions.', '123 Web Solutions', 'Los Angeles');

INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('Marketing Manager', 'Digital Marketing, Branding, Market Research', 'We are hiring a marketing manager, Join our team as a Marketing Manager and drive brand awareness and lead generation through comprehensive marketing strategies. You will manage digital campaigns, analyze market trends, collaborate with creative teams, and monitor campaign performance to maximize ROI.', 'Acme Corporation', 'Chicago');

INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('Graphic Designer', 'Adobe Photoshop, Illustrator, Typography', 'We are looking for a creative graphic designer, We are seeking a talented Graphic Designer to create visually appealing designs for both print and digital media. Your responsibilities will include developing creative concepts, collaborating with clients, using design tools, and ensuring designs align with brand guidelines.', 'Design Co.', 'Seattle');

INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('Sales Representative', 'Negotiation, Communication, Customer Service', 'We are seeking a motivated sales representative, Join our team as a Sales Representative and unleash your passion for driving business growth. As a proactive and results-oriented professional, you will identify and pursue new sales opportunities, build strong client relationships, and exceed revenue targets. With your exceptional communication and negotiation skills, you will effectively present our products or services, address customer needs, and contribute to our overall sales success.', 'Sales Inc.', 'Miami');

INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('Product Manager', 'Product Development, Market Analysis, Agile', 'We are hiring a product manager, As a Product Manager, you will be at the forefront of product development and strategy. You will collaborate with cross-functional teams to define product roadmaps, gather customer insights, and prioritize features. With your strong market knowledge and analytical skills, you will drive product success by delivering innovative solutions that meet customer needs and align with business goals.', 'Innovate Tech', 'Austin');

INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('Financial Analyst', 'Financial Modeling, Forecasting, Excel', 'We are looking for a financial analyst, As a Financial Analyst, you will play a vital role in supporting strategic decision-making through in-depth financial analysis and forecasting. You will prepare comprehensive reports and budgets, conduct market research to identify opportunities, and collaborate with cross-functional teams to develop financial models. Your expertise and insights will contribute to the overall financial health and growth of the organization.', 'Finance Corp.', 'New Jersey');

INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('HR Coordinator', 'Recruiting, Employee Relations, HRIS', 'We are seeking an HR coordinator, As an HR Coordinator, you will play a vital role in supporting the HR department and ensuring smooth HR operations. You will assist with recruitment and onboarding processes, maintain employee records, and handle HR-related inquiries. Additionally, you will help with HR projects, such as training programs and policy updates, and ensure compliance with relevant laws and regulations. Join our team and contribute to the effective management of our workforce.', 'HR Solutions', 'Denver');

INSERT INTO Jobs (job_title, job_skills, job_description, company, location)
VALUES ('Operations Manager', 'Supply Chain Management, Process Improvement', 'We are hiring an operations manager, As an Operations Manager, you will be responsible for overseeing day-to-day operations and ensuring smooth and efficient processes. Your role will involve developing operational policies and procedures, monitoring performance metrics, and identifying areas for improvement. With your leadership, you will drive the team towards operational excellence and play a vital role in achieving organizational goals.', 'Operations Inc.', 'Dallas');

INSERT INTO Users (	
	"user_name",
	"email"	,
	"qualification"	,
	"resume"	,
	"password"	,
	"skill")
	VALUES(
	"Kunwar Singh",
	"Test@gmail.com"	,
	"MCA"	,
	 null	,
	"Test@1234"	,
	".NET"		
);