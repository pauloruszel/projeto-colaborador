-- Competências --
INSERT INTO public.competencia (nm_competencia) VALUES('Java');
INSERT INTO public.competencia (nm_competencia) VALUES('HTML5');
INSERT INTO public.competencia (nm_competencia) VALUES('Angular');
INSERT INTO public.competencia (nm_competencia) VALUES('Spring');

-- Tipo Contato -->
INSERT INTO public.tipo_contato (nm_tipo_contato) VALUES('FIXO');
INSERT INTO public.tipo_contato (nm_tipo_contato) VALUES('CELULAR');
INSERT INTO public.tipo_contato (nm_tipo_contato) VALUES('COMERCIAL');
INSERT INTO public.tipo_contato (nm_tipo_contato) VALUES('EMAIL');
INSERT INTO public.tipo_contato (nm_tipo_contato) VALUES('FACEBOOK');
INSERT INTO public.tipo_contato (nm_tipo_contato) VALUES('LINKEDIN');

-- Endereço --
INSERT INTO public.endereco (ds_endereco) VALUES('Brasília - DF');

-- Colaborador -->
INSERT INTO public.colaborador (nm_colaborador, nm_cargo, nm_time, id_endereco)
VALUES('Paulo Santos', 'Full Stack Java Developer', 'Fábrica', 1);

-- Competência - Colaborador -->
INSERT INTO public.competencia_colaborador (id_colaborador, id_competencia) VALUES(1, 1);
INSERT INTO public.competencia_colaborador (id_colaborador, id_competencia) VALUES(1, 2);
INSERT INTO public.competencia_colaborador (id_colaborador, id_competencia) VALUES(1, 3);
INSERT INTO public.competencia_colaborador (id_colaborador, id_competencia) VALUES(1, 4);

-- Contato -->
INSERT INTO public.contato (ds_contato, id_tipo_contato) VALUES('61 98290-9420', 2);
INSERT INTO public.contato (ds_contato, id_tipo_contato) VALUES('paulo.santos@gmail.com', 4);
INSERT INTO public.contato (ds_contato, id_tipo_contato) VALUES('facebook.com/paulosantos', 5);
INSERT INTO public.contato (ds_contato, id_tipo_contato) VALUES('linkedin.com/pauloruszel', 6);

-- Colaborador - Contato --
INSERT INTO public.colaborador_contato (id_colaborador, id_contato) VALUES(1, 1);
INSERT INTO public.colaborador_contato (id_colaborador, id_contato) VALUES(1, 2);
INSERT INTO public.colaborador_contato (id_colaborador, id_contato) VALUES(1, 3);
INSERT INTO public.colaborador_contato (id_colaborador, id_contato) VALUES(1, 4);
