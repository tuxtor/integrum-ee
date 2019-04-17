
CREATE TABLE IF NOT EXISTS public.adm_sequence_generator (
                                               id_sequence VARCHAR(75) DEFAULT '' NOT NULL,
                                               sequence_value BIGINT DEFAULT 0 NOT NULL,
                                               CONSTRAINT adm_sequence_generator_pk PRIMARY KEY (id_sequence)
);
COMMENT ON COLUMN public.adm_sequence_generator.id_sequence IS 'normal_text - people name, items short name';
COMMENT ON COLUMN public.adm_sequence_generator.sequence_value IS 'integuer_qty - sequences, big integer qty';



CREATE TABLE IF NOT EXISTS public.adm_phrase
(
    phrase_id BIGINT DEFAULT 0 NOT NULL,
    author varchar(25) DEFAULT '' NOT NULL,
    phrase varchar(25) DEFAULT '' NOT NULL,
    CONSTRAINT adm_phrase_pk PRIMARY KEY (phrase_id)
);

insert into adm_phrase values (1, 'Twitter','Kotlin is cool');
insert into adm_phrase values (2, 'TIOBE','Java is the king');
