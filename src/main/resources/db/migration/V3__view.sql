CREATE VIEW agreement_view_expired as
select  ag.*, c.name company
from agreement ag JOIN company c ON ag.company_id=c.id where ag.end_date<now();

CREATE VIEW agreement_view_current as
select  ag.*, c.name company
from agreement ag JOIN company c ON ag.company_id=c.id where ag.end_date>now();

CREATE VIEW specific_view_current as
select  sp.*, ag.company company, ca.name career
from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id
                           JOIN career ca ON sp.career_id=ca.id where ag.end_date>now();

CREATE VIEW specific_view_expired as
select  sp.*, ag.company company, ca.name career
from specific_agreement sp JOIN agreement_view ag ON sp.agreement_id = ag.id
                           JOIN career ca ON sp.career_id=ca.id where ag.end_date<now();
